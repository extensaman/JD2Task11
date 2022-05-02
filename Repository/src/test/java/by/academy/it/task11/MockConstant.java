package by.academy.it.task11;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MockConstant {
    public static final String HORSE01_NICKNAME = "Kanapelka";
    public static final String HORSE01_BREED = "Pony";
    public static final String HORSE01_SUIT = "Grey";
    public static final String HORSE01_SPECIALIZATION = "Konkur";
    public static final Date HORSE01_DATE_OF_BIRTH =
            Date.from(LocalDate.of(2012, 10, 12)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant());
    public static final BigDecimal HORSE01_PRICE = BigDecimal.valueOf(1234.22);
}
