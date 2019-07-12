package chatToVid;

import java.io.IOException;

public class Person {
    String name;
    boolean status = false;
    boolean talk = false;

    XhtmlParser xhtmlParser = new XhtmlParser();

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isTalk() {
        return talk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
        try {
            xhtmlParser.setStatusParser(status, System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTalk(boolean talk) {
        this.talk = talk;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public Person(String name, boolean status, boolean talk) {
        this.name = name;
        this.status = status;
        this.talk = talk;
    }


}
