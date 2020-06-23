import java.util.Timer;
import java.util.TimerTask;

public class Transactions {

    public static void withdraw(Bank account, int value, TransactionListener event) {
        // loading begins
        //event.onLoading();

        // sends the error message and stops
        if ( account.getTotal() < value ) {
            // sends the error message and stops
            //event.onError("Total count is less than value to draw");
            return;
        }

        int time = (int) (Math.random() * ((1000 - 500) + 1)) + 500;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                account.setTotal(account.getTotal() - value);
                // sends the user
                //event.onSuccess(account);
                event.onComplete(account);
            }
        }, time);
    }
}
