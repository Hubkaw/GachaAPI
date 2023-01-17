package com.gachaapi.Paypal;

import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.PlayerPurchase;
import com.gachaapi.Repository.InGameCurrencyPurchaseRepository;
import com.gachaapi.Repository.PaymentMethodRepository;
import com.gachaapi.Repository.PlayerPurchaseRepository;
import com.gachaapi.Repository.PlayerRepository;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaypalService {

    @Autowired
    private APIContext apiContext;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerPurchaseRepository playerPurchaseRepository;
    @Autowired
    private InGameCurrencyPurchaseRepository inGameCurrencyPurchaseRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public Payment createPayment(
            String price,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException{
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(price);
        System.out.println(amount);

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());

        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }

    public void addToBalance(String payerID, Payment payment) {
        Player player = playerRepository.getReferenceById(Integer.parseInt(payerID));
        int value = (Integer.parseInt((player.getPlayerBalance()+payment.getTransactions().get(0).getAmount().getTotal())));
        player.setPlayerBalance(player.getPlayerBalance()+value);
        playerRepository.save(player);
        PlayerPurchase playerPurchase = new PlayerPurchase();
        playerPurchase.setBoughtAt(Timestamp.valueOf(payment.getCreateTime()));
        playerPurchase.setPlayerByPlayerIdPlayer(player);
        playerPurchase.setIngamecurrencypurchaseByInGameCurrencyPurchaseIdigcp(inGameCurrencyPurchaseRepository.findByVolume(value));
        playerPurchase.setPaymentmethodByPaymentMethodIdPaymentMethod(paymentMethodRepository.getReferenceById(1));
        playerPurchaseRepository.save(playerPurchase);
    }

}
