package ru.job4j.ood.lsp;

/**
 * 3. Инварианты (Invariants) —
 * все условия базового класса также должны быть сохранены и в подклассе
 * в данном случае, класс junior не выполняет проверки
 */
public class Resident {
    private boolean work;
    private boolean clean;
    private boolean goodMan;

    public Resident(boolean work, boolean clean, boolean goodMan) {
        this.work = work;
        this.clean = clean;
        this.goodMan = goodMan;
    }

    public Resident(boolean goodMan) {
        this.goodMan = goodMan;
    }

    public boolean isWork() {
        return work;
    }

    public boolean isClean() {
        return clean;
    }

    public boolean isGoodMan() {
        return goodMan;
    }
}

class Brother {

    protected Resident resident;

    public Brother(Resident resident) {
        validate(resident);
        this.resident = resident;
    }

    protected void validate(Resident resident) {
        if (resident.isClean()) {
            throw new IllegalArgumentException("......");
        }
        if (resident.isWork()) {
            throw new IllegalArgumentException("......");
        }
        if (resident.isGoodMan()) {
            throw new IllegalArgumentException("......");
        }
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        validate(resident);
        this.resident = resident;
    }
}

class Junior extends Brother {
    public Junior(Resident resident) {
        super(resident);
    }

    @Override
    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
