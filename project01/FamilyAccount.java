public class FamilyAccount {

    public static void main(String[] args) {

        boolean isFlag = true;
        String details = "Account\t\tBalance\t\tMoney\t\tDescribe\n";

        int balance = 10000;

        while (isFlag) {

            System.out.println("----------------------FamilyAccount---------------------------\n");
            System.out.println("                     1 Income and Expenditure Statement");
            System.out.println("                     2 Income Statement");
            System.out.println("                     3 Expenditure Statement");
            System.out.println("                     4 exit\n");
            System.out.print("                       Please chose one number:  ");

            // get user option(1-4)
            char selection = Utility.readMenuSelection();
            switch (selection) {

                case '1':
//                    System.out.println("1 Income and Expenditure Statement");
                    System.out.println("-----------------Current Income and Expenditure Statement");
//                    System.out.println("Account\tBalance\tMoney\tDescribe");
                    System.out.println(details);
                    System.out.println("----------------------------------------------------------");
                    break;
                case '2':
//                    System.out.println("2 Income Statement");
                    System.out.print("tract your inomce: ");
                    int money = Utility.readNumber();
                    System.out.print("add description: ");
                    String info = Utility.readString();

                    balance += money;

                    details += ("income\t\t" + balance + "\t\t" + money + "\t\t" + info + "\n");

                    System.out.println("-----------------------------------done-------------------\n");
                    break;
                case '3':
//                    System.out.println("3 Expenditure Statement");
                    System.out.println("tract your expenditure");
                    money = Utility.readNumber();
                    System.out.print("add description: ");
                    info = Utility.readString();

                    if (balance >= money) {
                        balance -= money;
                        details += ("expenses\t" + balance + "\t\t" + money + "\t\t" + info + "\n");
                    } else {
                        System.out.println("expenses exceed balance, unable to use the Service");
                    }


                    System.out.println("-----------------------------------done-------------------\n");
                    break;
                case '4':
                    System.out.println("choose to exit(Y/N): ");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }
        }
    }
}
