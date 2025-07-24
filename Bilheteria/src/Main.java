import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        int selectOpts = -1;
        ArrayList<Event> events = initializeEvents();

        String messageMenu = "<html><h1>Selecione uma opção</h1>"
                + "<br>1. Eventos<br>2. Receita Total Acumulada<br>0. Sair</html>";

        while (selectOpts != 0) {
            String input = JOptionPane.showInputDialog(null, messageMenu);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                break;
            }

            try {
                selectOpts = Integer.parseInt(input); // The main object of the try

                switch (selectOpts) {
                    case 1:
                        showEvents(events);
                        break;
                    case 2:
                        showAcumulatedTotalRecipe(events);
                        break;
                    case 0:
                        // Exit
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        }
    }

    public static ArrayList<Event> initializeEvents() {
        ArrayList<Event> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 9, 15);
        Date date1 = calendar.getTime();
        calendar.set(2024, 8, 20);
        Date date2 = calendar.getTime();

        events.add(new Movie("O Senhor dos Anéis", date1, "19:00", "Cinema 1", 20.0f));
        events.add(new Movie("Star Wars", date2, "21:00", "Cinema 2", 25.0f));
        events.add(new Theater("Romeu e Julieta", date1, "19:00", "Teatr Municipal", 80.0f));
        events.add(new Theater("João e Maria", date1, "21:30", "Teatro Estadual 2", 55.0f));
        events.add(new Concert("Rock Festival", date2, "20:00", "Estádio do Morumbi", 100.0f));
        events.add(new Concert("Jazz Night", date2, "22:00", "Teatro Municipal", 30.0f));

        return events;
    }

    public static void showAcumulatedTotalRecipe(ArrayList<Event> events) {
        double acumulatedTotalRecipe = 0;

        for (Event event : events) {
            acumulatedTotalRecipe += event.recipe();
        }

        String message = "<html><h1>Receita Total acumulada</h1>"
                + String.format("%.2f </html>", acumulatedTotalRecipe);
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showEvents(ArrayList<Event> events) {
        int selectEvents = -1;

        while (selectEvents != 0) {
            String input = JOptionPane.showInputDialog(null, makeEventList(events));
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                break;
            }

            try {
                selectEvents = Integer.parseInt(input); // The main object of the try

                if (selectEvents > 0 && selectEvents <= events.size()) {
                    showEventsActions(events, getEventIndex(selectEvents, events));
                } else if (selectEvents != 0) {
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        }
    }

    public static String makeEventList(ArrayList<Event> events) {
        String message = "<html><h1>Eventos</h1><ol>";
        for (int i = 0; i < events.size(); i++) {
            message += String.format("<li>", i + 1) + events.get(i).toString() + "<br>";
        }
        message += "</ol><br>0. Sair</hmtl>";

        return message;
    }

    public static void showEventsActions(ArrayList<Event> events, int eventIndex) {
        int selectEventsOpts = -1;

        String message = String.format(
                "<html><h1>%s</h1>1. Comprar Ingresso<br>2. Informações do Evento<br>0. Sair</html>",
                events.get(eventIndex).getName());

        while (selectEventsOpts != 0) {
            String input = JOptionPane.showInputDialog(null, message);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                break;
            }

            try {
                selectEventsOpts = Integer.parseInt(input); // The main object of the try

                if (selectEventsOpts == 1) {
                    events.get(eventIndex).sellTicket();
                } else if (selectEventsOpts == 2) {
                    eventInfo(events, eventIndex);
                } else if (selectEventsOpts != 0) {
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        }
    }

    public static int getEventIndex(int selectEvents, ArrayList<Event> events) {
        int eventIndex = -1;

        for (int i = 0; i <= events.size(); i++) {
            if (selectEvents == i) {
                eventIndex = i - 1;
                break;
            }
        }

        return eventIndex;
    }

    public static void eventInfo(ArrayList<Event> events, int eventIndex) {
        String statment = "<html><h1>Extrato</h1>" + events.get(eventIndex).statment() + "</html>";
        String recipe = "<html><br><h1>Receita total</h1>"
                + String.format("R$: %.2f </html>", events.get(eventIndex).recipe());

        JOptionPane.showMessageDialog(null, statment);
        JOptionPane.showMessageDialog(null, recipe);
    }
}
