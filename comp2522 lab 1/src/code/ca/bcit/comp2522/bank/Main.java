package ca.bcit.comp2522.bank;

public class Main {

    private static final int AE_BIRTH_YEAR = 1879;
    private static final int AE_BIRTH_MONTH = 3;
    private static final int AE_BIRTH_DAY = 14;
    private static final int AE_DEATH_YEAR = 1955;
    private static final int AE_DEATH_MONTH = 4;
    private static final int AE_DEATH_DAY = 18;
    private static final int AE_JOIN_YEAR = 1900;
    private static final int AE_JOIN_MONTH = 1;
    private static final int AE_JOIN_DAY = 1;
    private static final int AE_PIN = 3141;
    private static final int AE_LAST_ACTIVITY_YEAR = 1950;
    private static final int AE_LAST_ACTIVITY_MONTH = 10;
    private static final int AE_LAST_ACTIVITY_DAY = 14;
    private static final int AE_DEPOSIT = 1000;
    private static final int AE_WITHDRAWAL = 100;

    private static final int NM_BIRTH_YEAR = 1918;
    private static final int NM_BIRTH_MONTH = 7;
    private static final int NM_BIRTH_DAY = 18;
    private static final int NM_DEATH_YEAR = 2013;
    private static final int NM_DEATH_MONTH = 12;
    private static final int NM_DEATH_DAY = 5;
    private static final int NM_JOIN_YEAR = 1994;
    private static final int NM_JOIN_MONTH = 5;
    private static final int NM_JOIN_DAY = 10;
    private static final int NM_PIN = 4664;
    private static final int NM_DEPOSIT = 2000;
    private static final int NM_WITHDRAWAL = 200;

    private static final int FK_BIRTH_YEAR = 1907;
    private static final int FK_BIRTH_MONTH = 7;
    private static final int FK_BIRTH_DAY = 6;
    private static final int FK_DEATH_YEAR = 1954;
    private static final int FK_DEATH_MONTH = 7;
    private static final int FK_DEATH_DAY = 13;
    private static final int FK_JOIN_YEAR = 1940;
    private static final int FK_JOIN_MONTH = 1;
    private static final int FK_JOIN_DAY = 1;
    private static final int FK_PIN = 1907;
    private static final int FK_DEPOSIT = 500;
    private static final int FK_WITHDRAWAL = 50;

    private static final int JC_BIRTH_YEAR = 1954;
    private static final int JC_BIRTH_MONTH = 4;
    private static final int JC_BIRTH_DAY = 7;
    private static final int JC_JOIN_YEAR = 1980;
    private static final int JC_JOIN_MONTH = 10;
    private static final int JC_JOIN_DAY = 1;
    private static final int JC_PIN = 1954;
    private static final int JC_DEPOSIT = 3000;
    private static final int JC_WITHDRAWAL = 500;

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
                new Date(AE_BIRTH_YEAR, AE_BIRTH_MONTH, AE_BIRTH_DAY),
                new Date(AE_DEATH_YEAR, AE_DEATH_MONTH, AE_DEATH_DAY),
                new Date(AE_JOIN_YEAR, AE_JOIN_MONTH, AE_JOIN_DAY),
                "abc123");

        nelsonMandelaClient = new BankClient(nelsonMandela,
                new Date(NM_BIRTH_YEAR, NM_BIRTH_MONTH, NM_BIRTH_DAY),
                new Date(NM_DEATH_YEAR, NM_DEATH_MONTH, NM_DEATH_DAY),
                new Date(NM_JOIN_YEAR, NM_JOIN_MONTH, NM_JOIN_DAY),
                "654321");

        fridaKahloClient = new BankClient(fridaKahlo,
                new Date(FK_BIRTH_YEAR, FK_BIRTH_MONTH, FK_BIRTH_DAY),
                new Date(FK_DEATH_YEAR, FK_DEATH_MONTH, FK_DEATH_DAY),
                new Date(FK_JOIN_YEAR, FK_JOIN_MONTH, FK_JOIN_DAY),
                "frd123");

        jackieChanClient = new BankClient(jackieChan,
                new Date(JC_BIRTH_YEAR, JC_BIRTH_MONTH, JC_BIRTH_DAY),
                null,
                new Date(JC_JOIN_YEAR, JC_JOIN_MONTH, JC_JOIN_DAY),
                "chan789");

        albertEinsteinAccount = new BankAccount(albertEinsteinClient,
                "abc123",
                new Date(AE_JOIN_YEAR, AE_JOIN_MONTH, AE_JOIN_DAY),
                new Date(AE_LAST_ACTIVITY_YEAR, AE_LAST_ACTIVITY_MONTH, AE_LAST_ACTIVITY_DAY),
                AE_PIN);

        nelsonMandelaAccount = new BankAccount(nelsonMandelaClient,
                "654321",
                new Date(NM_JOIN_YEAR, NM_JOIN_MONTH, NM_JOIN_DAY),
                NM_PIN);

        fridaKahloAccount = new BankAccount(fridaKahloClient,
                "frd123",
                new Date(FK_JOIN_YEAR, FK_JOIN_MONTH, FK_JOIN_DAY),
                new Date(FK_DEATH_YEAR, FK_DEATH_MONTH, FK_DEATH_DAY),
                FK_PIN);

        jackieChanAccount = new BankAccount(jackieChanClient,
                "chan789",
                new Date(JC_JOIN_YEAR, JC_JOIN_MONTH, JC_JOIN_DAY),
                JC_PIN);

        System.out.println(albertEinstein.getInitial());
        System.out.println(albertEinstein.getFullName());
        System.out.println(albertEinstein.getReverseName());
        System.out.println(albertEinstein.getDetails());
        System.out.println(albertEinsteinClient.getDetails());
        albertEinsteinAccount.deposit(AE_DEPOSIT, AE_PIN);
        albertEinsteinAccount.withdraw(AE_WITHDRAWAL, AE_PIN);
        System.out.println(albertEinsteinAccount.getDetails());

        System.out.println(nelsonMandela.getInitial());
        System.out.println(nelsonMandela.getFullName());
        System.out.println(nelsonMandela.getReverseName());
        System.out.println(nelsonMandela.getDetails());
        System.out.println(nelsonMandelaClient.getDetails());
        nelsonMandelaAccount.deposit(NM_DEPOSIT, NM_PIN);
        nelsonMandelaAccount.withdraw(NM_WITHDRAWAL, NM_PIN);
        System.out.println(nelsonMandelaAccount.getDetails());

        System.out.println(fridaKahlo.getInitial());
        System.out.println(fridaKahlo.getFullName());
        System.out.println(fridaKahlo.getReverseName());
        System.out.println(fridaKahlo.getDetails());
        System.out.println(fridaKahloClient.getDetails());
        fridaKahloAccount.deposit(FK_DEPOSIT, FK_PIN);
        fridaKahloAccount.withdraw(FK_WITHDRAWAL, FK_PIN);
        System.out.println(fridaKahloAccount.getDetails());

        System.out.println(jackieChan.getInitial());
        System.out.println(jackieChan.getFullName());
        System.out.println(jackieChan.getReverseName());
        System.out.println(jackieChan.getDetails());
        System.out.println(jackieChanClient.getDetails());
        jackieChanAccount.deposit(JC_DEPOSIT, JC_PIN);
        jackieChanAccount.withdraw(JC_WITHDRAWAL, JC_PIN);
        System.out.println(jackieChanAccount.getDetails());
    }
}