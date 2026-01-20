package ca.bcit.comp2522.bank;

public class Main {

    public static void main(String[] args)
    {

        Name albertEinstein;
        Name nelsonMandela;
        Name fridaKahlo;
        Name jackieChan;
        BankClient albertEinsteinClient;
        BankClient nelsonMandelaClient;
        BankClient fridaKahloClient;
        BankClient jackieChanClient;
        BankAccount albertEinsteinAccount;
        BankAccount nelsonMandelaAccount;
        BankAccount fridaKahloAccount;
        BankAccount jackieChanAccount;

        albertEinstein = new Name("Albert", "Einstein");
        nelsonMandela = new Name("Nelson", "Mandela");
        fridaKahlo = new Name("Frida", "Kahlo");
        jackieChan = new Name("Jackie", "Chan");

        albertEinsteinClient = new BankClient(albertEinstein,
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Date(1900, 1, 1),
                "abc123");

        nelsonMandelaClient = new BankClient(nelsonMandela,
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                new Date(1994, 5, 10),
                "654321");

        fridaKahloClient = new BankClient(fridaKahlo,
                new Date(1907, 7, 6),
                new Date(1954, 7, 13),
                new Date(1940, 1, 1),
                "frd123");

        jackieChanClient = new BankClient(jackieChan,
                new Date(1954, 4, 7),
                null,
                new Date(1980, 10, 1),
                "chan789");


        albertEinsteinAccount = new BankAccount(albertEinsteinClient,
                "abc123",
                new Date(1900, 1, 1),
                new Date(1950, 10, 14),
                3141);

        nelsonMandelaAccount = new BankAccount(nelsonMandelaClient,
                "654321",
                new Date(1994, 5, 10),
                4664);

        fridaKahloAccount = new BankAccount(fridaKahloClient,
                "frd123",
                new Date(1940, 1, 1),
                new Date(1954, 7, 13),
                1907);

        jackieChanAccount = new BankAccount(jackieChanClient,
                "chan789",
                new Date(1980, 10, 1),
                1954);

// Albert Einstein
        System.out.println(albertEinstein.getInitial());
        System.out.println(albertEinstein.getFullName());
        System.out.println(albertEinstein.getReverseName());
        System.out.println(albertEinstein.getDetails());
        System.out.println(albertEinsteinClient.getDetails());
        albertEinsteinAccount.deposit(1000, 3141);
        albertEinsteinAccount.withdraw(100, 3141);
        System.out.println(albertEinsteinAccount.getDetails());

// Nelson Mandela
        System.out.println(nelsonMandela.getInitial());
        System.out.println(nelsonMandela.getFullName());
        System.out.println(nelsonMandela.getReverseName());
        System.out.println(nelsonMandela.getDetails());
        System.out.println(nelsonMandelaClient.getDetails());
        nelsonMandelaAccount.deposit(2000, 4664);
        nelsonMandelaAccount.withdraw(200, 4664);
        System.out.println(nelsonMandelaAccount.getDetails());


// Frida Kahlo
        System.out.println(fridaKahlo.getInitial());
        System.out.println(fridaKahlo.getFullName());
        System.out.println(fridaKahlo.getReverseName());
        System.out.println(fridaKahlo.getDetails());
        System.out.println(fridaKahloClient.getDetails());
        fridaKahloAccount.deposit(500, 1907);
        fridaKahloAccount.withdraw(50, 1907);
        System.out.println(fridaKahloAccount.getDetails());

// Jackie Chan
        System.out.println(jackieChan.getInitial());
        System.out.println(jackieChan.getFullName());
        System.out.println(jackieChan.getReverseName());
        System.out.println(jackieChan.getDetails());
        System.out.println(jackieChanClient.getDetails());
        jackieChanAccount.deposit(3000, 1954);
        jackieChanAccount.withdraw(500, 1954);
        System.out.println(jackieChanAccount.getDetails());

    }



}