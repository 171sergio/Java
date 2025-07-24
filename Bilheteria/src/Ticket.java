import java.util.Date;

abstract class Ticket implements Revenue{
    private Date saleDate;
    private double value;

    public Ticket(double value) {
        this(value, new Date());
    }

    public Ticket(double value, Date saleDate) {
        this.saleDate = saleDate;
        this.value = value;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    abstract String getType();

    @Override
    public double recipe() {
        return value;
    }

    @Override
    public String statment() {
        return "Data: "+ saleDate + " Tipo: " + getType() +  " Valor: " + value;
    }

}
