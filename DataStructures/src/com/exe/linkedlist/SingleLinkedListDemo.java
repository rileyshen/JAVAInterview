package src.com.exe.linkedlist;

/**
 * @Description:
 * @Author RileyShen
 * @Create 2021-07-14
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        HeroCard hero1 = new HeroCard(1, "aa", "big j");
        HeroCard hero2 = new HeroCard(2, "bb", "big m");
        HeroCard hero3 = new HeroCard(3, "cc", "big q");
        HeroCard hero4 = new HeroCard(4, "dd", "big k");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.list();

        // test update
        HeroCard newC1 = new HeroCard(2, "ee", "big y");
        singleLinkedList.update(newC1);

        System.out.println("update the list -----");
        singleLinkedList.list();

        System.out.println("after delete the list -----");
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.delete(3);
        singleLinkedList.delete(2);
        singleLinkedList.list();
    }
}

// define a singlelinedlist, to manage our card
class SingleLinkedList {
    // init a head, dont't store a real card info
    private HeroCard head = new HeroCard(0, "", "");

    public HeroCard getHead() {
        return head;
    }
    // add card to the list
    // case 1: dont't have to think about the order
    // find the last node
    // link the last node's next to the new node
    public void add(HeroCard card) {

        HeroCard temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = card;
    }

//    // add the card to the assigned order.
//    public void addByOrder(HeroCard card) {
//
//        HeroCard temp = head;
//        boolean flag = false;
//
//        while (temp.next != null) {
//            if (temp.next.no > card.no) {
//                break;
//            } else if (temp.next.no == card.no) {
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//
//        if(flag) {
//            System.out.printf("the id%d is already exist:\n", card.no);
//        } else {
//            card.next = temp.next;
//            temp.next = card;
//
//        }
//    }

    // add the card to the assigned order.
    public void addByOrder(HeroCard card) {

        HeroCard temp = head;


        while (temp.next != null) {
            if (temp.next.no > card.no) {
                break;
            } else if (temp.next.no == card.no) {
                System.out.printf("the id%d is already exist:\n", card.no);
                return;
            }
            temp = temp.next;
        }

        card.next = temp.next;
        temp.next = card;


    }
    // update the card info
    public void update(HeroCard newCard) {
        // empty?
        if (head.next == null) {
            System.out.println("the list is empty~~");
            return;
        }

        HeroCard temp = head.next;
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

        HeroCard temp = head;
        while (temp.next != null) {
            if (temp.next.no == no ) {

                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.printf("there is no such %d in the list", no);

    }

    // leetcode 22
    // reverse, find k 个

    public void list() {
        // whether the list is empty
        if (head.next == null) {
            System.out.println("It is an empty list");
            return;
        }
        HeroCard temp = head.next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

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
                ']';
    }
}