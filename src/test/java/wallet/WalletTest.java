package wallet;

import com.edu.interfaces.Converter;
import com.edu.model.Bank;
import com.edu.model.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wallet.mock.ConverterMock;

public class WalletTest {

    @Test
    public void shouldGetMoney() {
        Wallet w = new Wallet();
        w.addMoney("RUB", 12.8);

        Assertions.assertEquals(w.getMoney("RUB"), 12.8);
    }
    @Test
    public void shouldAddMoneyToExistingCurrency() {
        Wallet w = new Wallet();
        w.addMoney("RUB", 12.8);
        w.addMoney("RUB", 12.8);

        Assertions.assertEquals(w.getMoney("RUB"), 25.6);
    }
    @Test
    public void shouldAddMoneyToMultipleCurrencies() {
        Wallet w = new Wallet();
        w.addMoney("RUB", 12.8);
        w.addMoney("USD", 12.9);

        Assertions.assertEquals(w.getMoney("RUB"), 12.8);
        Assertions.assertEquals(w.getMoney("USD"), 12.9);
    }
    @Test
    public void shouldRemoveMoneyFromWallet() {
        Wallet w = new Wallet();
        w.addMoney("RUB", 12.8);
        w.addMoney("USD", 12.9);

        Assertions.assertEquals(w.getMoney("RUB"), 12.8);
        Assertions.assertEquals(w.getMoney("USD"), 12.9);

        w.removeMoney("RUB", 10.1);

        Assertions.assertEquals(w.getMoney("RUB"), 2.7);
        Assertions.assertEquals(w.getMoney("USD"), 12.9);
    }
    @Test
    public void shouldToString() {
        Wallet w = new Wallet();
        w.addMoney("RUB", 300.1);
        w.addMoney("USD", 100.2);

        Assertions.assertEquals(w.toString(), "{ 300.1 RUB, 100.2 USD }");
    }

    @Test
    public void shouldReturnTotalMoney() {
        Converter mock = new ConverterMock();
        Wallet w = new Wallet(mock);
        w.addMoney("RUB", 300.1);
        w.addMoney("USD", 100.2);

        double d = w.getTotalMoney("RUB");
        Assertions.assertEquals(310.1, d);
    }
}
