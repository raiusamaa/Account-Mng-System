public abstract class bank {
    String bname;
    String oname;
    String address;
    int cnumber;
    public bank(String bname, String oname, String address, int cnumber)
    {
        super();
        this.bname = bname;
        this.oname = oname;
        this.address = address;
        this.cnumber = cnumber;
    }
    abstract String cname();
    abstract String caddress();
    abstract String type();
    abstract long accN();
    abstract int number();
    abstract int amount();
    abstract void setAmount(int a);
    abstract String datee();
    abstract void withDraw(long acc,int amount,int c);
    abstract  void checkBalance(long acc,int c);
    abstract  void displayDetails(long acc,int c);
    abstract void makeDeposit(long a,int am,int b);
}