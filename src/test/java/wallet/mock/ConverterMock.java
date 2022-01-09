package wallet.mock;

import com.edu.interfaces.Converter;

public class ConverterMock implements Converter {

    @Override
    public double convert(double amount, String from, String to) {
        return 10;
    }

    @Override
    public void addCurrency(String currency) {

    }
}
