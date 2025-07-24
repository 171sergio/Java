import java.util.Date;
import javax.swing.JOptionPane;

public class Concert extends Event {

    private int vipTicketsSold;
    int vipmax;

    public Concert(String name, Date date, String time, String location, float ticketPrice) {
        super(name, date, time, location, 150, ticketPrice);
        this.vipmax = (int) (getTotalTickets() * 0.1);
    }

    @Override
    public void sellTicket() {
        while (true) {
            String input = JOptionPane.showInputDialog(null,
                    String.format(
                            "Venda de Ingressos:\n1 - Regular    R$%.2f\n2 - Meia-Entrada    R$%.2f\n3 - VIP    R$%.2f\n0 - Não quero comprar ingressos\nDigite o que deseja:",
                            getTicketPrice(), getHalfTicketPrice(), getVipTicketPrice()));

            int N;

            try {
                N = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite um número válido.");
                continue;
            }

            if (!isTicketAvailable()) {
                JOptionPane.showMessageDialog(null, "Ingressos esgotados!");
                return;
            }

            switch (N) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo da venda de ingressos.");
                    return;

                case 1:
                    tickets.add(new RegularTicket(new Date(), getTicketPrice()));
                    JOptionPane.showMessageDialog(null, "Ingresso regular vendido!");
                    break;

                case 2:
                    tickets.add(new HalfPriceTicket(new Date(), getTicketPrice()));
                    JOptionPane.showMessageDialog(null, "Ingresso meia-entrada vendido!");
                    break;

                case 3:
                    if (vipTicketsSold < vipmax) {
                        tickets.add(new VipTicket(new Date(), getTicketPrice()));
                        vipTicketsSold++;
                        JOptionPane.showMessageDialog(null, "Ingresso VIP vendido!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Os ingressos VIP's esgotaram.");
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite um número válido.");
                    break;
            }
        }
    }

    public int GetvipTicketsSold() {
        return vipTicketsSold;
    }

    public float getVipTicketPrice() {
        return ticketPrice * 2;
    }
}
