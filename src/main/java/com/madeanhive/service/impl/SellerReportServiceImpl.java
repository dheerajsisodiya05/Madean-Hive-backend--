package com.madeanhive.service.impl;

import com.madeanhive.model.Seller;
import com.madeanhive.model.SellerReport;
import com.madeanhive.repository.SellerReportRepository;
import com.madeanhive.service.SellerReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerReportServiceImpl implements SellerReportService {

    private final SellerReportRepository sellerReportRepository;


    @Override
    public SellerReport getSellerReport(Seller seller) {
        SellerReport report = sellerReportRepository.findBySellerId(seller.getId());
        if(report == null){
            SellerReport newReport = new SellerReport();
            newReport.setSeller(seller);
            return sellerReportRepository.save(newReport);
        }
        return report;
    }


    @Override
    public SellerReport updateSellerReport(SellerReport sellerReport) {
        if (sellerReport == null) {
            throw new IllegalArgumentException("SellerReport cannot be null");
        }
        return sellerReportRepository.save(sellerReport);
    }

}
