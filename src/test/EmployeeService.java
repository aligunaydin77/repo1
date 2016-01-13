
package test;

import java.util.HashMap;

interface OrdersAndInvoices {}
class PurchaseOrder implements OrdersAndInvoices {
   private Integer orderId = null;
   public PurchaseOrder(Integer newOrderId) {
      this.orderId = newOrderId;
   }
   @Override
   public boolean equals(Object anotherPurchaseOrder) {
      return anotherPurchaseOrder instanceof PurchaseOrder &&
      this.orderId.equals(((PurchaseOrder)anotherPurchaseOrder).getOrderId());
   }
   public int hashCode() {
      return this.orderId.intValue();
   }
   private Integer getOrderId() {
      return this.orderId;
   }
}
class Invoice implements OrdersAndInvoices {
   private String relatedPurchaseOrderId;
   public int hashCode() {
      return Integer.parseInt(this.relatedPurchaseOrderId);
   }
   public Invoice(String purchaseOrderId) {
      this.relatedPurchaseOrderId = purchaseOrderId;
   }
}

public class EmployeeService {
public static void main(String[] args) {
	HashMap<OrdersAndInvoices, String> ordersAndInvoices = new HashMap<OrdersAndInvoices, String>();
	ordersAndInvoices.put(new PurchaseOrder(12345),"Sales Dept, Acme Inc.");
	ordersAndInvoices.put(new Invoice("12345"),"Accounts Dept., Acme Inc.");
	ordersAndInvoices.put(new Invoice("12346"),"Accounts Dept., IKM Inc.");
	        
	System.out.println(ordersAndInvoices.get(new PurchaseOrder(12345)));
	System.out.println(ordersAndInvoices.get(new Invoice("12345")));
}	
}