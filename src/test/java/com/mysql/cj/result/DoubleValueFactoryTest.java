package com.mysql.cj.result;

import static org.junit.Assert.assertEquals;
import com.mysql.cj.conf.DefaultPropertySet;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DoubleValueFactoryTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Test
  public void getTargetTypeNameTest() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Double", (new DoubleValueFactory(new DefaultPropertySet())).getTargetTypeName());
  }
  @Test
  public void createFromBitTest() {
    // Arrange, Act and Assert
    assertEquals(Double.valueOf(0.0),
        (new DoubleValueFactory(new DefaultPropertySet())).createFromBit(new byte[24], 1, 1));
  }
  @Test
  public void createFromDoubleTest() {
    // Arrange, Act and Assert
    assertEquals(Double.valueOf(1.0), (new DoubleValueFactory(new DefaultPropertySet())).createFromDouble(1.0));
  }
  @Test
  public void createFromBigDecimalTest() {
    // Arrange, Act and Assert
    thrown.expect(NullPointerException.class);
    (new DoubleValueFactory(new DefaultPropertySet())).createFromBigDecimal(null);
  }
  @Test
  public void createFromLongTest() {
    // Arrange, Act and Assert
    assertEquals(Double.valueOf(1.0), (new DoubleValueFactory(new DefaultPropertySet())).createFromLong(1L));
  }
  @Test
  public void createFromBigIntegerTest() {
    // Arrange, Act and Assert
    thrown.expect(NullPointerException.class);
    (new DoubleValueFactory(new DefaultPropertySet())).createFromBigInteger(null);
  }
}
