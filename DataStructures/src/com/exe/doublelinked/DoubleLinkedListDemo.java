package src.com.exe.doublelinked;



/**
 * @Description:
 * @Author RileyShen
 * @Create 2021-07-17
 */






public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("Double Linked List test");

        HeroCard2 hero1 = new HeroCard2(1, "aa", "big j");
        HeroCard2 hero2 = new HeroCard2(2, "bb", "big m");
        HeroCard2 hero3 = new HeroCard2(3, "cc", "big q");
        HeroCard2 hero4 = new HeroCard2(4, "dd", "big k");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        HeroCard2 newHero = new HeroCard2(4, "ee", "big k");
        doubleLinkedList.update(newHero);

        System.out.println("after update the list-----------------");
        doubleLinkedList.list();


        doubleLinkedList.delete(3);
        System.out.println("after deleting the list-----------------");
        doubleLinkedList.list();

    }
}



class DoubleLinkedList {
    // init a head, dont't store a real card info
    private HeroCard2 head = new HeroCard2(0, "", "");

    public HeroCard2 getHead() {
        return head;
    }


    public void list() {
        // whether the list is empty
        if (head.next == null) {
            System.out.println("It is an empty list");
            return;
        }
        HeroCard2 temp = head.next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }
    // add card to the LAST of the list
    // case 1: dont't have to think about the order
    // find the last node
    // link the last node's next to the new node
    public void add(HeroCard2 card) {

        HeroCard2 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = card;
        card.prev = temp;
    }

    // update the card info
    public void update(HeroCard2 newCard) {
        // empty?
        if (head.next == null) {
            System.out.println("the list is empty~~");
            return;
        }

        HeroCard2 temp = head.next;
        while (temp != null) {
            if (temp.no == newCard.no) {
                temp.name = newCard.name;
                temp.nickname = newCard.nickname;
                return;
            }
            temp = temp.next;
        }
        System.out.printf("there is no cardId%d card", newCard.no);
    }

    // delete the card info
    public void delete(int no) {
        // empty?
        if (head.next == null) {
            System.out.println("the list is empty~~");
            return;
        }

        HeroCard2 temp = head.next;
        while (temp != null) {
            if (temp.no == no) {

                temp.prev.next = temp.next;
                // be careful temp is the last card case

                if (temp.next != null) {

                    temp.next.prev = temp.prev;
                }
                return;
            }

                temp = temp.next;
            }
            System.out.printf("there is no such %d in the list", no);
        }
    }



// define a HeroCard,
class HeroCard2 {
    public int no;
    public String name;
    public String nickname;
    public HeroCard2 next;
    public HeroCard2 prev;

    // constructor
    public HeroCard2(int no, String name, String nickname) {
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
                ']';
    }
}