import java.util.ArrayList;
import java.util.Scanner;

public class Product {
   private int ID;
   private int Sum;
   private String Name;
   Product(int i,int s,String n)
   {
       ID=i;
       Sum=s;
       Name=n;
   }
   public int getID()
   {
       return ID;
   }
   public int getSum()
   {
       return Sum;
   }
   public String getName()
   {
       return Name;
   }
   public void increaseQuantity(int Num)
   {
        Sum+=Num;
   }
   public int SellOne()
   {
       return Sum--;
   }
    public String toString()
   {
       return "  ID为:"+ID+"  名字为:"+Name+"  存量为:"+Sum;
   }

     static class StockDemo {
        public static void main(String[] args)
        {
            StockManager myProducts=new StockManager();
            myProducts.addProduct();
            myProducts.addProduct();
            myProducts.addProduct();
            myProducts.printProductDetails();
            System.out.println("请输入要添加产品数量的产品编号:");
            myProducts.delivery(2);
            System.out.println("根据编号查找产品:");
            myProducts.findProduct(3).toString();
            System.out.println("根据名字查找产品");
            myProducts.findProductByName("Book").toString();
            System.out.println("库存量低于20的产品有:");
            myProducts.printLowStockProducts(20);
            System.out.println("根据编号查找产品并返回产品数量");
            System.out.println(myProducts.numberInStock(1));
        }
    }

     static class StockManager {
       static Scanner in = new Scanner(System.in);
       private ArrayList<Product> products;
       StockManager()
       {
           products=new ArrayList<Product>();
       }
        public void addProduct()
        {
            System.out.println("请输入ID:");
            int I=in.nextInt();
            System.out.println("请输入名字:");
            String N=in.next();
            System.out.println("请输入库存数量:");
            int S=in.nextInt();
            Product p=new Product(I,S,N);
            for(int i=0;i<products.size();i++)
            {
                if(p.getName()==products.get(i).getName())
                {
                    System.out.println("该名称产品已存在");
                    return;
                }
            }
               products.add(p);
        }
        public void printProductDetails()
        {
           if(products.isEmpty())
           {
               System.out.println("存储错误");
           }
           System.out.println("所有产品信息如下:");
           for(int i=0;i<products.size();i++)
           {
               products.get(i).toString();
           }
        }
        public Product findProduct(int ID)
        {
            if(products.isEmpty())
            {
                System.out.println("存储错误");
                return null;
            }
           for(int i=0;i<products.size();i++)
           {
               if(ID==products.get(i).getID())
               {
                   return products.get(i);
               }
           }
           return null;
        }
        public int numberInStock(int ID)
        {
            if(products.isEmpty())
            {
                System.out.println("存储错误");
                return 0;
            }
            for(int i=0;i<products.size();i++)
            {
                if(ID==products.get(i).getID())
                {
                    return products.get(i).getSum();
                }
            }
            return 0;
        }
        public void delivery(int ID)
        {
            if(products.isEmpty())
            {
                System.out.println("存储错误");
                return;
            }
            for(int i=0;i<products.size();i++)
              {
                  if(ID==products.get(i).getID())
                  {
                     products.get(i).increaseQuantity(10);
                  }
              }
        }
        public void printLowStockProducts(int Num)
        {
            if(products.isEmpty())
            {
                System.out.println("存储错误");
                return;
            }
            for(int i=0;i<products.size();i++)
            {
               if(products.get(i).getSum()<Num)
               {
                   products.get(i).toString();
               }
            }
        }
        public Product findProductByName(String Name)
        {
            if(products.isEmpty())
            {
                System.out.println("存储错误");
                return null;
            }
            for(int i=0;i<products.size();i++)
            {
                if(products.get(i).getName()==Name)
                {
                       return products.get(i);
                }
            }
            return null;
        }
    }
}
