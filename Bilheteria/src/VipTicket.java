import java.util.Date;

public class VipTicket extends Ticket {
    public VipTicket(Date saleDate, double value) {
        super(value * 2, saleDate);
    }

    @Override
    public String getType(){
        return "Vip";
    }
}
