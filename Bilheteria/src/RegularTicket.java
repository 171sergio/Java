import java.util.Date;

public class RegularTicket extends Ticket {
    public RegularTicket(Date saleDate, double value) {
        super(value, saleDate);
    }

    @Override
    public String getType(){
        return "Comum";
    }

}
