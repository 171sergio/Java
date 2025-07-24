import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Event implements Revenue {

    protected String name;
    protected Date date;
    protected String time;
    protected String location;
    protected int totalTickets;
    protected float ticketPrice;
    protected ArrayList<Ticket> tickets;

    public Event(String name, Date date, String time, String location, int totalTickets, float ticketPrice) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.totalTickets = totalTickets;
        this.ticketPrice = ticketPrice;
        this.tickets = new ArrayList<Ticket>();
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Ticket ticket : tickets) {
            totalSales += ticket.getValue();
        }
        return totalSales;
    }

    public boolean isTicketAvailable() {
        return tickets.size() < totalTickets;
    }

    public abstract void sellTicket();

    @Override
    public double recipe() {
        double total = 0;
        for (Ticket ticket : this.tickets) {
            total += ticket.recipe();
        }
        return total;
    }

    @Override
    public String statment() {
        String statment = "";
        for (Ticket ticket : this.tickets) {
            statment += ticket.statment() + "<br>";
        }
        return statment;
    }

    @Override
    public String toString() {
        return "<h2>" + this.getName() + "</h2>Data: " + this.getFormatedDate() + "<br>Hora: " + this.getTime() + "<br>Local: "
                + this.getLocation()
                + String.format("<br>Preço: R$%.2f", this.getTicketPrice())
                + String.format("<h3><b>Ingressos</b></h3>Vendidos: %d<br>Disponíveis: %d", this.tickets.size(),
                        this.getTotalTickets() - this.tickets.size());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public String getFormatedDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String formatedDate = format.format(date);
        return formatedDate;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public float getHalfTicketPrice() {
        return ticketPrice / 2;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

}
