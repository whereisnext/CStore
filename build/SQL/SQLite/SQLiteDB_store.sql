create table Customer(customerId, customerName, contectPerson, district, postcode, address, mobile, phone, fax, url, email, accountBank, accountNumber, accountPerson, mark, status, customerPinYin, abstractCustomer, insertDate);
create table Supplier(supplierId, supplierName, contectPerson, district, postcode, address, mobile, phone, fax, url, email, accountBank, accountNumber, accountPerson, mark, status, supplierPinYin, abstractSupplier, insertDate);
create table Product(productId, productCode, productName, brand, unit, spec, color, buyPrice, salePrice, mark, status, supplierId, supplierName, productPinYin, abstractProduct, insertDate);
create table SaleOrderSheet(saleOrderSheetId, saleOrderNo, customerName, receivePerson, mobile, fax, district, deliverAddress, deliverPostcode, deliverDate, mark, totalPrice, status, salesmanId, creatorId, orderPinYin, abstractOrder, insertDate);
create table SaleOrderProduct(saleOrderProductId, saleOrderSheetId, productName, number, spec, color, salePrice, mark, insertDate);
create table PurchaseOrderSheet(purchaseOrderSheetId, purchaseOrderNo, saleOrderNo, supplierName, receivePerson, mobile, deliverAddress, deliverPostcode, deliverDate, mark, totalPrice, status, salesmanId, creatorId, orderPinYin, abstractOrder, insertDate);
create table PurchaseOrderProduct(purchaseOrderProductId, purchaseOrderSheetId, supplierName, productName, spec, color, number, totalSalePrice, mark, insertDate);
create table Stock(stockId, supplierName, productName, number, spec, color, averagePrice, mark, warehouseLocation, weight, insertDate);
create table ImportStock(importStockId, supplierName, productName, number, spec, color, salePrice, mark, insertDate);
create table ExportStock(exportStockId, supplierName, productName, number, spec, color, salePrice, mark, insertDate);

