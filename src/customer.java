public class customer extends bank {
    String cname;
    String caddress;
    int cnumber;
    String type;
    long accountN;
    int amount;
    String date;
    public customer(String bname, String oname, String address, int cnumber, String name, String address2, int number,
                    String type,long a,int amount,String date)
    {
        super(bname, oname, address, cnumber);
        this.cname = name;
        this.caddress = address2;
        this.cnumber = number;
        this.type=type;
        this.accountN=a;
        this.amount=amount;
        this.date=date;
    }

    @Override
    String cname()
    {
        return cname;
    }

    @Override
    String caddress()
    {
        return caddress;
    }

    @Override
    String type()
    {
        return type;
    }

    @Override
    long accN()
    {
        return accountN;
    }

    @Override
    int number()
    {
        return cnumber;
    }
    @Override
    int amount()
    {
        return amount;
    }
    @Override
    void setAmount(int a)
    {
        amount=a;
    }

    @Override
    String datee() {
        return date;
    }

    @Override
    void withDraw(long acc, int amount, int c) {

    }

    @Override
    void checkBalance(long acc, int c) {

    }

    @Override
    void displayDetails(long acc, int c) {

    }

    @Override
    void makeDeposit(long a, int am, int b)
    {

    }
}

class checking extends customer
{
    public checking(String bname, String oname, String address, int cnumber, String name, String address2, int number, String type,long a,int amount,String date)
    {
        super(bname, oname, address, cnumber, name, address2, number, type,a,amount,date);
    }


}

class saving extends customer
{
    public saving(String bname, String oname, String address, int cnumber, String name, String address2, int number, String type,long a,int amount,String date)
    {
        super(bname, oname, address, cnumber, name, address2, number, type,a,amount,date);
    }
    void calculateZakkat(int amou)
    {
        if (amou>=2000)
        {
            double temp=0;
            temp= (amou*2.5)/100;
            System.out.println("Zakkat on this account is "+temp+"\n");
        }
    }
    void calculateInterest(int a,int b)
    {
        double temp=0;
        temp=(a*b)/100;
        System.out.println("Interest on your amount is "+temp+"\n");
    }
}
