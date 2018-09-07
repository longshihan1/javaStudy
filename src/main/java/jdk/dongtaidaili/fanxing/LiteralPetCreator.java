package jdk.dongtaidaili.fanxing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by longshihan on 2017/4/30.
 */
public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
            Arrays.asList(Pet.class, Dog.class, Cat.class, Mutt.class, EgyptianMau.class));
    private static final List<Class<? extends Pet>> types = allTypes.subList(
            allTypes.indexOf(Mutt.class), allTypes.size());
    public List<Class<? extends Pet>> getTypes() {
        return types;
    }
}
