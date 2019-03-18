package Dacl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product extends ProductDb {

	public Product() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Product(Product p)throws SQLException {
		super();
		this.name=p.getName();
		this.id=p.getId();
		this.Description=p.getDescription();
		this.price=p.getPrice();
		
		
	} 
	public int id;
	  public String name;
	  public String Description;
	  public double price;
	  public String image;
	  
	 public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return Description;
	}
	public double getPrice() {
		return price;
	}
	 public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
	
	public ArrayList<Product> select(String cat)throws SQLException
	{
		ArrayList<Product> pro = new ArrayList<>();
		ResultSet rs;
		ps=conn.prepareStatement("SELECT * FROM products WHERE category=?");
		ps.setString(1, cat);
		if(cat.equals("All")) {
			ps = conn.prepareStatement("SELECT * FROM products");
			rs=ps.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setDescription(rs.getString(3));
				prod.setPrice(rs.getDouble(4));
				prod.setImage(rs.getString(6));
				pro.add(prod);
			}
			return pro;	
		}
		else {
		rs=ps.executeQuery();
		while(rs.next()) {
			Product prod = new Product();
			prod.setId(rs.getInt(1));
			prod.setName(rs.getString(2));
			prod.setDescription(rs.getString(3));
			prod.setPrice(rs.getDouble(4));
			prod.setImage(rs.getString(6));
			pro.add(prod);
		}
		return pro;	
	}
  }
	
	
	
	public double[] pricelist(String[] items)throws SQLException {
			double amt=0.0;
			ResultSet rs;
			StringBuilder base = new StringBuilder("SELECT price FROM products WHERE name IN(");
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<items.length;i++) {
				sb.append("?,");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append(")");
			base.append(sb);
			System.out.println(base);
			ps=conn.prepareStatement(base.toString());
				for(int i=1;i<=items.length;i++) 
				{
				ps.setString(i, items[i-1]);
				}

				System.out.println("the query with input is "+ps.toString());
				rs = ps.executeQuery();
				double[] p=new double[items.length];
				int i=0;
				while(rs.next()) {
					p[i]=rs.getDouble(1);
					System.out.println(p[i]);
					amt+=p[i];
					i++;
				}
			for(double j:p) {
				System.out.println(j);
			}
			return p;
		
 
   }
}

	
