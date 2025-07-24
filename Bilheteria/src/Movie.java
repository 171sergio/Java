import java.util.Date;
import javax.swing.JOptionPane;

public class Movie extends Event {

    public Movie(String name, Date date, String time, String location, float ticketPrice) {
        super(name, date, time, location, 200, ticketPrice);
    }

    @Override
    public void sellTicket() {
        int N = -1;

        while (N != 0) {
            String input = JOptionPane.showInputDialog(null, String.format(
                    "Venda de Ingressos:\n1 - Regular    R$%.2f\n2 - Meia-Entrada    R$%.2f\n0 - Não quero comprar ingressos\nDigite o que deseja:",
                    this.getTicketPrice(), this.getHalfTicketPrice()));

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

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite um número válido.");
                    break;
            }
        }
    }
}
