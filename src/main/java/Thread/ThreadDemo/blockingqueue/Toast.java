package Thread.ThreadDemo.blockingqueue;

/**
 * Created by dell on 2017/2/21.
 */
public class Toast {
    public Toast(int id) {
        this.id = id;
    }

    public enum Status {DRY, BUTTERED, JAMMED}

    ;
    private Status status = Status.DRY;
    private final int id;

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Toast " + id + ":" + status;
    }
}
