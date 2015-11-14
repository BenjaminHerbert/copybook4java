package dk.nversion.copybook.converters;

import dk.nversion.copybook.exceptions.TypeConverterException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class IntegerToBoolean extends IntegerToInteger {

    @Override
    public void validate(Class<?> type, int size, int decimals) {
        if(!(Boolean.class.equals(type) || Boolean.TYPE.equals(type))) {
            throw new TypeConverterException("Only supports converting to and from int or Integer");
        }
    }

    @Override
    public Object to(byte[] bytes, int offset, int length, int decimals, boolean removePadding) {
        return (int)super.to(bytes, offset, length, decimals, removePadding) != 0;
    }

    @Override
    public byte[] from(Object value, int length, int decimals, boolean addPadding) {
        return super.from((boolean)value ? 1 : 0, length, decimals, addPadding);
    }
}
