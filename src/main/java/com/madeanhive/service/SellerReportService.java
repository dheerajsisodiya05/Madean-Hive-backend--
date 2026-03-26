package com.madeanhive.service;

import com.madeanhive.model.Seller;
import com.madeanhive.model.SellerReport;

public interface SellerReportService {
    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);

}
