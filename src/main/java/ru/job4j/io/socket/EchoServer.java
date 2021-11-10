package ru.job4j.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        /**
         *ServerSocket создает сервер. Чтобы клиент мог узнать, где находится сервер ему нужен адрес и порт.
         * По аналогии с людьми мы обращаемся по имени, чтобы начать разговор.
         * 9000 - это порт. По умолчанию адрес будет localhost.
         */
        try (ServerSocket server = new ServerSocket(9000)) {
            /**
             * Следующее условие говорит о том, что сервер работает, пока его принудительно не закроют
             */
            while (!server.isClosed()) {
                /**
                 * server.acсept - ожидает, когда к нему обратиться клиент.
                 * Программа переходит в режим ожидания.
                 */
                Socket socket = server.accept();
                /**
                 *  Когда клиент обратился к серверу программа получает входной поток
                 *  и может отправить данные в выходной поток.
                 */
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    /**
                     * В ответ мы записываем строчку.
                     */
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    StringBuilder builder = new StringBuilder();
                    /**
                     * В программе читается весь входной поток.
                     */
                    for (String str = reader.readLine(); str != null && !str.isEmpty(); str = reader.readLine()) {
                        System.out.println("test: " + str);
                        if (str.contains("Exit")) {
                            server.close();
                            break;
                        }
                        builder.append(str);
                    }
                    /**
                     * После чтения отправляем ответ окончательно.
                     */
                    send(out, builder.toString());
                    out.flush();
                } catch (Exception e) {
                    LOG.error("ALARM we have problems (reading or writing)!!", e);
                }
            }
        } catch (Exception e) {
            LOG.error("ALARM we have problems with ServerSocket !!", e);
        }
    }

    private static void send(OutputStream out, String request) {
        if (request != null && !request.isEmpty()) {
            if (request.contains("Hello")) {
                try {
                    out.write(("Hello, world!!!.\r\n\r\n").getBytes());
                } catch (Exception e) {
                    LOG.error("Alarm send errors", e);
                }
            } else {
                try {
                    out.write(("What??\r\n\r\n").getBytes());
                } catch (Exception e) {
                    LOG.error("Alarm send errors", e);
                }
            }
        }
    }
}
