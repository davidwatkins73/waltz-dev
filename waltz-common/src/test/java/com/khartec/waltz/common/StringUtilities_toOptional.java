package com.khartec.waltz.common;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class StringUtilities_toOptional {

    @Test
    public void simpleToOptional(){
        String str = "abc";
        assertEquals(Optional.of("abc"), StringUtilities.toOptional(str));
    }

    @Test
    public void simpleToOptionalWithEmptyStr(){
        String str = "";
        assertEquals(Optional.empty(), StringUtilities.toOptional(str));
    }

    @Test
    public void simpleToOptionalWithNullStr(){
        String str = null;
        assertEquals(Optional.empty(), StringUtilities.toOptional(str));
    }
}
