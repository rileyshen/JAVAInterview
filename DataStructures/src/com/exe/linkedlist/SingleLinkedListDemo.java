package src.com.exe.linkedlist;

/**
 * @Description:
 * @Author RileyShen
 * @Create 2021-07-14
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

    }
}

// define a singlelinedlist, to manage our card
class SingleLinkedList {
    // init a head, dont't store a real card info
    private HeroCard head = new HeroCard(0, "", "");

    // add card to the list
    public void add(HeroCard card) {

    }
}


// define a HeroCard,
class HeroCard {
    public int no;
    public String name;
    public String nickname;
    public HeroCard next;

    // constructor
    public HeroCard(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroCard[" +
                "no=" + no +
                ", name='" + name +
                ", nickname='" + nickname +
                ", next=" + next +
                ']';
    }
}