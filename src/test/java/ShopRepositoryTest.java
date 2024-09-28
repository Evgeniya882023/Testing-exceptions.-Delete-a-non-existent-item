import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Капуста", 100);
    Product product2 = new Product(2, "Свекла", 50);
    Product product3 = new Product(3, "Зубная паста", 200);

    @Test //должен проверять успешность удаления существующего элемента
    public void shouldDeleteElementInShopRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removebyId(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //должен проверять генерацию NotFoundException при попытке удаления несуществующего элемента
    public void deleteNonexistentElement() {
        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removebyId(4);
        });
    }
}

