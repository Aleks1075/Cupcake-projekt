package dat.backend.model.entities;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    private List<Cupcake> cupcakeList = new ArrayList<>();

    public ShoppingCart()
    {
    }

    public void add(Cupcake cupcake)
    {
        cupcakeList.add(cupcake);
    }

    public int getNumberOfCupcakes()
    {
        return cupcakeList.size();
    }

    public List<Cupcake> getCupcakeList()
    {
        return cupcakeList;
    }

    public void resetCart()
    {
        cupcakeList.clear();
    }

    public double getTotalPrice()
    {
        double totalPrice = 0;
        for (Cupcake cupcake : cupcakeList)
        {
            totalPrice += cupcake.getPrice();
        }
        return totalPrice;
    }

    public void deleteItem(int item_id)
    {
        for(int i = 0; i < cupcakeList.size(); i++)
        {
            if(cupcakeList.get(i).getTop().getId() == item_id)
            {
                cupcakeList.remove(i);
            }
        }
    }

    public void addItem(int item_id)
    {
        for(int i = 0; i < cupcakeList.size(); i++)
        {
            if(cupcakeList.get(i).getTop().getId() == item_id)
            {
                cupcakeList.get(i).setQuantity(cupcakeList.get(i).getQuantity() + 1);
            }
        }
    }

    public void removeItem(int item_id)
    {
        for(int i = 0; i < cupcakeList.size(); i++)
        {
            if(cupcakeList.get(i).getTop().getId() == item_id)
            {
                if(cupcakeList.get(i).getQuantity() > 1)
                {
                    cupcakeList.get(i).setQuantity(cupcakeList.get(i).getQuantity() - 1);
                }
            }
        }
    }
}
