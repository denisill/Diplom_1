package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Burger burger;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(2)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(1);
        Mockito.verify(burger).removeIngredient(1);
    }

    @Test
    public void moveIngredient() {
        burger.moveIngredient(0, 1);
        Mockito.verify(burger).moveIngredient(0, 1);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(20f);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(40f));
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\r\n= sauce hot sauce =\r\n(==== black bun ====)\r\n\r\nPrice: 300,000000\r\n";
        assertThat(actual, equalTo(expected));
    }
}