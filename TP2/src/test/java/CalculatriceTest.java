import org.example.Calculatrice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    private Calculatrice calculatrice;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        calculatrice=mock(Calculatrice.class);
    }

    @Test
    public void testAdditionner() {

        when(calculatrice.additionner(2, 3)).thenReturn(5);


        int result=calculatrice.additionner(2,3);


        assertEquals(5, result);



        verify(calculatrice,never()).additionner(2, 3);
        // calculatrice.test_another_method();

        verifyNoMoreInteractions(calculatrice);




    }
}