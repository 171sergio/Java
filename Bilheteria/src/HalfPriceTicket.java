import java.util.Date;

public class HalfPriceTicket extends Ticket {
    public HalfPriceTicket(Date saleDate, double value) {
        super(value * 0.5, saleDate);
    }

    @Override
    public String getType(){
        return "Meia Entrada";
    }
}
