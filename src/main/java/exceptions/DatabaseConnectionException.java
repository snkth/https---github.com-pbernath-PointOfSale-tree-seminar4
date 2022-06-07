
package exceptions;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Peter
 */
public class DatabaseConnectionException extends Exception {
    
    public DatabaseConnectionException (){
        super("Developer log: Connection to inventory system failed at " + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES) + " and through IP-address '8.8.8.8'.");

    }
}
