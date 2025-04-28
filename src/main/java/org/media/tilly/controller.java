package org.media.tilly;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class controller {
    @FXML
    private Pane root;
    private Pane basketContent = new Pane();
    creditInformationInterface creditInformation = new creditInformation();
    basketInterface basket = new basket();
    List<Product> products = new ArrayList<Product>();
    Label basketSummaryPrice = new Label("0.00DKK");
    public void initialize() {
        products.add(new Product(1, "Coca-Cola 330ml", "a nice cold beverage", 1.0, 2));

        Pane productOverview = new Pane();
        productOverview.setPrefSize(env.WINDOW_WIDTH * 0.7, env.WINDOW_HEIGHT);
        productOverview.setLayoutX(0);
        productOverview.setLayoutY(0);
        productOverview.setStyle("-fx-background-color: gray; -fx-border-radius: 2");





        for (int i = 0; i < products.size(); i++) {
            Pane productPreview = new Pane();
            productPreview.setPrefSize(productOverview.getPrefWidth() / 5, productOverview.getPrefHeight() / 5);
            productPreview.setLayoutX(0);
            productPreview.setLayoutY(0);
            productPreview.setStyle("-fx-background-color: gray; -fx-border-radius: 2; -fx-border-color: black;");
            /*ImageView productImage = new ImageView();
            productImage.setFitHeight(productOverview.getPrefHeight());
            productImage.setFitWidth(productOverview.getPrefWidth());
            productImage.setImage(new Image("/" + products.get(i).getId() + ".png"));*/

            //productPreview.getChildren().add(productImage);
            Label name = new Label(products.get(i).getName());
            name.setPrefHeight(20);
            name.setPrefWidth(120);
            name.setLayoutY(productPreview.getPrefHeight() / 2 - name.getPrefHeight() / 2);
            name.setLayoutX(productPreview.getPrefWidth() / 2 - name.getPrefWidth() / 2);
            Label price = new Label(products.get(i).getPrice() + " DKK");
            price.setPrefHeight(20);
            price.setPrefWidth(120);
            price.setLayoutY(name.getLayoutY() + name.getPrefHeight());
            price.setLayoutX(productPreview.getPrefWidth() / 2 - price.getPrefWidth() / 2);
            productPreview.getChildren().add(name);
            productPreview.getChildren().add(price);
            /*if (products.get(i).getQuantity() == 0) {
                Pane blackoutOverlay = new Pane();
                blackoutOverlay.setPrefSize(productPreview.getPrefWidth(), productPreview.getPrefHeight());
                blackoutOverlay.setLayoutX(0);
                blackoutOverlay.setLayoutY(0);
                blackoutOverlay.setStyle("fx-background-color: black;");
                blackoutOverlay.setOpacity(0.8);
                Label outOfStock = new Label("Out of stock ");
                outOfStock.setStyle("-fx-font-size: 14; -fx-text-fill: red;");
                outOfStock.setPrefHeight(20);
                outOfStock.setPrefWidth(120);
                outOfStock.setLayoutY(blackoutOverlay.getPrefHeight() / 2 - outOfStock.getPrefHeight() / 2);
                outOfStock.setLayoutX(blackoutOverlay.getPrefWidth() / 2 - outOfStock.getPrefWidth() / 2);
                productPreview.getChildren().add(outOfStock);
                productPreview.getChildren().add(blackoutOverlay);
            }*/
            Product product = products.get(i);
            productPreview.setOnMouseClicked(mouseEvent -> {
                addToBasket(product);
                for (int j = 0; j < basket.getProducts().size(); j++) {
                    System.out.println(basket.getProducts().get(j).getProduct().getName() + ": " + basket.getProducts().get(j).getAmount() );
                }

            });
            productOverview.getChildren().add(productPreview);
        }

        root.getChildren().add(productOverview);
        root.setStyle("-fx-background-color: lightgray");
        Pane basket = new Pane();

        basket.setLayoutY(0);
        basket.setStyle("-fx-border-color: gray; -fx-border-width: 2;");
        basket.setPrefHeight(env.WINDOW_HEIGHT);
        basket.setPrefWidth(env.WINDOW_WIDTH * 0.3);
        basket.setLayoutX(env.WINDOW_WIDTH - basket.getPrefWidth());
        Label basketTitle = new Label("Basket");
        basketTitle.setFont(new Font("Arial", 18));
        basketTitle.setLayoutX(basket.getPrefWidth() /2 - basketTitle.getPrefWidth() / 2);
        basketTitle.setLayoutY(0);
        basket.getChildren().add(basketTitle);

        basketContent.setLayoutY(20);
        basketContent.setPrefWidth(basket.getPrefWidth());
        basketContent.setPrefHeight(env.WINDOW_HEIGHT * 0.9);
        basketContent.setStyle("-fx-border-color: gray; -fx-border-width: 2;");
        basket.getChildren().add(basketContent);

        Pane basketSummary = new Pane();
        basketSummary.setPrefHeight(20);
        basketSummary.setPrefWidth(basket.getPrefWidth());
        basketSummary.setLayoutY(basketContent.getPrefHeight() - basketSummary.getPrefHeight());

        basketSummary.setStyle("-fx-border-color: gray; -fx-border-width: 2;");
        basketContent.getChildren().add(basketSummary);

        Label basketSummaryTitle = new Label("Basket Summary");
        basketSummaryTitle.setLayoutX(0);
        basketSummaryTitle.setLayoutY(0);
        basketSummary.getChildren().add(basketSummaryTitle);

        basketSummaryPrice.setPrefWidth(60);
        basketSummaryPrice.setLayoutX(basketSummary.getPrefWidth() - basketSummaryPrice.getPrefWidth());
        basketSummary.getChildren().add(basketSummaryPrice);



        Button buttonCheckout = new Button("Checkout");
        buttonCheckout.setPrefHeight(env.WINDOW_HEIGHT * 0.1);
        buttonCheckout.setPrefWidth(basket.getPrefWidth());
        buttonCheckout.setLayoutX(basket.getPrefWidth() /2 - buttonCheckout.getPrefWidth() /2);
        buttonCheckout.setLayoutY(env.WINDOW_HEIGHT * 0.9 + 20);

        buttonCheckout.setOnMouseClicked(event -> {
            employeeLogin();
        });
        basket.getChildren().add(buttonCheckout);






        root.getChildren().add(basket);


    }
    public void employeeLogin() {
        Pane blackoutOverlay = new Pane();
        blackoutOverlay.setStyle("-fx-background-color: black");
        blackoutOverlay.setOpacity(0.8);
        blackoutOverlay.setLayoutX(0);
        blackoutOverlay.setLayoutY(0);
        blackoutOverlay.setPrefHeight(env.WINDOW_HEIGHT);
        blackoutOverlay.setPrefWidth(env.WINDOW_WIDTH);
        root.getChildren().add(blackoutOverlay);

        Pane pinField = new Pane();
        pinField.setPrefSize(env.WINDOW_WIDTH * 0.5, env.WINDOW_HEIGHT * 0.5);
        pinField.setLayoutX(env.WINDOW_WIDTH / 2 - pinField.getPrefWidth() / 2);
        pinField.setLayoutY(env.WINDOW_HEIGHT / 2 - pinField.getPrefHeight() / 2);
        pinField.setStyle("-fx-background-color: lightgray; -fx-border-color: gray; -fx-border-width: 2;");

        PasswordField pinTextField = new PasswordField();
        pinTextField.setPrefSize(pinField.getPrefWidth() /2, pinField.getPrefHeight() * 0.1);
        pinTextField.setLayoutX(pinField.getPrefWidth() / 2 - pinTextField.getPrefWidth() / 2);
        pinTextField.setLayoutY(pinField.getPrefHeight() *0.05);
        pinTextField.setPromptText("Enter PIN");
        pinTextField.setOnKeyPressed(event -> {if (event.getCode() == KeyCode.ENTER) {
            AuthenticationProcess AuthProc = new AuthenticationProcess(pinTextField.getText());
            if (AuthProc.success()) {
                employeecheckout();
                root.getChildren().remove(blackoutOverlay);
                root.getChildren().remove(pinField);
            }
            else {
                Label passwordIncorrecLabel = new Label("The entered pin is incorrect.");
                passwordIncorrecLabel.setFont(new Font("Arial", 16));
                passwordIncorrecLabel.setStyle("-fx-text-fill: red; -fx-text-alignment: center");
                passwordIncorrecLabel.setPrefSize(pinTextField.getPrefWidth(), pinTextField.getPrefHeight());
                passwordIncorrecLabel.setLayoutY(pinTextField.getLayoutY() + pinTextField.getPrefHeight());
                passwordIncorrecLabel.setLayoutX(pinTextField.getLayoutX());
                pinField.getChildren().add(passwordIncorrecLabel);
            }







        }});
        /*
         **/









        pinField.getChildren().add(pinTextField);
        Pane numbpad = new Pane();
        numbpad.setPrefSize(pinField.getPrefWidth() *0.5, pinField.getPrefHeight() *0.6);
        numbpad.setLayoutX(pinField.getPrefWidth() *0.5 - numbpad.getPrefWidth() / 2);
        numbpad.setLayoutY(numbpad.getPrefHeight() *0.5);

        Button[] numbpadButtons = new Button[12];
        for (int i = 0; i < 9; i++) {
            numbpadButtons[i] = new Button("" + (i + 1) );


        }
        numbpadButtons[9] = new Button("←");
        numbpadButtons[10] = new Button("0");
        numbpadButtons[11] = new Button("OK");

        for (int i = 0; i < numbpadButtons.length; i++) {
            numbpadButtons[i].setPrefSize(numbpad.getPrefWidth() * 0.3, numbpad.getPrefHeight() * 0.25);
        }


        //Set positions for the Keypad

        //toprow: multipl. 0
        numbpadButtons[0].setLayoutY(0);
        numbpadButtons[0].setLayoutX(0);
        numbpadButtons[1].setLayoutY(0);
        numbpadButtons[1].setLayoutX(numbpad.getPrefWidth() / 2 - numbpadButtons[1].getPrefWidth() / 2);
        numbpadButtons[2].setLayoutY(0);
        numbpadButtons[2].setLayoutX(numbpad.getPrefWidth() - numbpadButtons[2].getPrefWidth());
        //top center row: multipl.1
        numbpadButtons[3].setLayoutY(numbpadButtons[0].getPrefHeight());
        numbpadButtons[3].setLayoutX(0);
        numbpadButtons[4].setLayoutY(numbpadButtons[1].getPrefHeight());
        numbpadButtons[4].setLayoutX(numbpad.getPrefWidth() / 2 - numbpadButtons[4].getPrefWidth() / 2);
        numbpadButtons[5].setLayoutY(numbpadButtons[2].getPrefHeight());
        numbpadButtons[5].setLayoutX(numbpad.getPrefWidth() - numbpadButtons[4].getPrefWidth());

        //bottom center row multipl.2

        numbpadButtons[6].setLayoutY(numbpadButtons[3].getPrefHeight() * 2);
        numbpadButtons[6].setLayoutX(0);
        numbpadButtons[7].setLayoutY(numbpadButtons[4].getPrefHeight() * 2);
        numbpadButtons[7].setLayoutX(numbpad.getPrefWidth() / 2 - numbpadButtons[4].getPrefWidth() / 2);
        numbpadButtons[8].setLayoutY(numbpadButtons[5].getPrefHeight() * 2);
        numbpadButtons[8].setLayoutX(numbpad.getPrefWidth() - numbpadButtons[8].getPrefWidth());
        //bottom row: multipl.3
        numbpadButtons[9].setLayoutY(numbpadButtons[3].getPrefHeight() *3 );
        numbpadButtons[9].setLayoutX(0);
        numbpadButtons[10].setLayoutY(numbpadButtons[4].getPrefHeight() *3);
        numbpadButtons[10].setLayoutX(numbpad.getPrefWidth() / 2 - numbpadButtons[10].getPrefWidth() / 2);
        numbpadButtons[11].setLayoutY(numbpadButtons[5].getPrefHeight() * 3);
        numbpadButtons[11].setLayoutX(numbpad.getPrefWidth() - numbpadButtons[11].getPrefWidth());
        //asingning action to buttons


        for (int i = 0; i < 9; i++) {
            String temp = numbpadButtons[i].getText();
            numbpadButtons[i].setOnMouseClicked(e -> {pinTextField.setText(pinTextField.getText() + temp);});
        }
        numbpadButtons[9].setOnMouseClicked(e -> {
            if (pinTextField.getText().isEmpty()) {
                root.getChildren().remove(blackoutOverlay) ;
                root.getChildren().remove(pinField);
            }
            pinTextField.setText(pinTextField.getText().substring(0, pinTextField.getText().length() - 1));
        });
        numbpadButtons[10].setOnMouseClicked(e -> {pinTextField.setText(pinTextField.getText() + "0");});
        numbpadButtons[11].setOnMouseClicked(e -> {
            AuthenticationProcess AuthProc = new AuthenticationProcess(pinTextField.getText());
            if (AuthProc.success()) {
                root.getChildren().remove(blackoutOverlay);
                root.getChildren().remove(pinField);
                employeecheckout();

            }
            else {
                Label passwordIncorrecLabel = new Label("The entered pin is incorrect.");
                passwordIncorrecLabel.setFont(new Font("Arial", 16));
                passwordIncorrecLabel.setStyle("-fx-text-fill: red; -fx-text-alignment: center");
                passwordIncorrecLabel.setPrefSize(pinTextField.getPrefWidth(), pinTextField.getPrefHeight());
                passwordIncorrecLabel.setLayoutY(pinTextField.getLayoutY() + pinTextField.getPrefHeight());
                passwordIncorrecLabel.setLayoutX(pinTextField.getLayoutX());
                pinField.getChildren().add(passwordIncorrecLabel);
            }


        });

        for (int i = 0; i < numbpadButtons.length; i++) {
            numbpad.getChildren().add(numbpadButtons[i]);
        }




        pinField.getChildren().add(numbpad);
        root.getChildren().add(pinField);
    }


    public void addToBasket(Product product) {


        for (int i = 0; i < basket.getProducts().size(); i++) {
            if (basket.getProducts().get(i).getProduct().getId() == product.getId()) {
                basket.getProducts().get(i).addAmount(1);
                updateBasket();
                return;
            }
        }
        basket.addProduct(new basketElements(product, 1));
        updateBasket();


    }
    public void updateBasket() {
        basketContent.getChildren().removeAll();
        Pane[] basketItems = new Pane[basket.getProducts().size()];
        for (int i = 0; i < basket.getProducts().size(); i++) {
            basketItems[i] = new Pane();
            basketItems[i].setPrefSize(basketContent.getPrefWidth(), basketContent.getPrefHeight() * 0.2);
            basketItems[i].setLayoutX(basketContent.getPrefWidth() / 2);
            basketItems[i].setLayoutY(0);
            basketItems[i] = new Pane();
            Label itemName = new Label( basket.getProducts().get(i).getAmount() +""+ basket.getProducts().get(i).getProduct().getName());
            Label itemPrice = new Label(basket.getProducts().get(i).getProduct().getPrice() + " DKK");
            itemName.setPrefSize(120, 40);
            itemPrice.setPrefSize(120, 40);
            itemName.setLayoutY(basketItems[i].getPrefHeight() /2 );
            itemName.setLayoutX(basketItems[i].getPrefWidth() *0.01);
            itemPrice.setLayoutY(basketItems[i].getPrefHeight() /2);
            itemPrice.setLayoutX(basketItems[i].getPrefWidth() *0.8 - itemPrice.getPrefWidth());
        }
        double totalprice = 0.0;
        for (int i = 0; i < basket.getProducts().size(); i++) {
            totalprice += basket.getProducts().get(i).getAmount() * basket.getProducts().get(i).getProduct().getPrice();

        }
        basketSummaryPrice.setText(totalprice+"DKK");

    }

    Pane employeeCheckoutOverlay = new Pane();
    public void employeecheckout () {
        Pane blackoutOverlay = new Pane();
        blackoutOverlay.setStyle("-fx-background-color: black");
        blackoutOverlay.setOpacity(0.8);
        blackoutOverlay.setLayoutX(0);
        blackoutOverlay.setLayoutY(0);
        blackoutOverlay.setPrefHeight(env.WINDOW_HEIGHT);
        blackoutOverlay.setPrefWidth(env.WINDOW_WIDTH);
        root.getChildren().add(blackoutOverlay);

        employeeCheckoutOverlay.setStyle("-fx-background-color: lightgrey");
        employeeCheckoutOverlay.setPrefHeight(env.WINDOW_HEIGHT*0.8);
        employeeCheckoutOverlay.setPrefWidth(env.WINDOW_WIDTH*0.8);
        employeeCheckoutOverlay.setLayoutX(env.WINDOW_WIDTH/2 - employeeCheckoutOverlay.getPrefWidth() / 2);
        employeeCheckoutOverlay.setLayoutY(env.WINDOW_HEIGHT/2 - employeeCheckoutOverlay.getPrefHeight() /2);

        Button backButton = new Button("Back");
        backButton.setLayoutX(0);
        backButton.setLayoutY(0);
        backButton.setOnMouseClicked(e->{
            basket.removeAllProducts();
            root.getChildren().remove(blackoutOverlay);
            root.getChildren().remove(employeeCheckoutOverlay);});
        updateBasket();
        employeeCheckoutOverlay.getChildren().add(backButton);



        Label funds = new Label("Balance: " + creditInformation.getFunds() + "DKK");
        funds.setPrefSize(200, 120);
        funds.setLayoutX(employeeCheckoutOverlay.getPrefWidth() - funds.getPrefWidth());
        funds.setLayoutY(employeeCheckoutOverlay.getPrefHeight() *0.001);
        funds.setFont(new Font("Arial", 16));
        employeeCheckoutOverlay.getChildren().add(funds);
        Pane summary = new Pane();
        summary.setStyle("-fx-background-color: gray");
        summary.setPrefSize(employeeCheckoutOverlay.getPrefWidth() * 0.8, employeeCheckoutOverlay.getPrefHeight() * 0.8);
        summary.setLayoutX(employeeCheckoutOverlay.getPrefWidth() /2 - summary.getPrefWidth() /2);
        summary.setLayoutY(employeeCheckoutOverlay.getPrefHeight() /2 - summary.getPrefHeight() /2);
        Label summaryTitel = new Label("Summary");
        summaryTitel.setFont(new Font("Arial", 16));
        summaryTitel.setPrefSize(20, 20);
        summaryTitel.setLayoutX(employeeCheckoutOverlay.getPrefWidth() /2 - summaryTitel.getPrefWidth() /2);
        summaryTitel.setLayoutY(employeeCheckoutOverlay.getPrefHeight() *0.01);
        List<basketElements> products = basket.getProducts();
        Pane[] productDetails = new Pane[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productDetails[i] = new Pane();
            productDetails[i].setPrefSize(summary.getPrefWidth(), summary.getPrefHeight() * 0.2);
            productDetails[i].setStyle("-fx-background-color: lightgrey; -fx-border-color: black; -fx-border-radius: 1");
            Label name = new Label(basket.getProducts().get(i).getAmount() +"x " +products.get(i).getProduct().getName());
            name.setFont(new Font("Arial", 14));
            name.setTextAlignment(TextAlignment.CENTER);
            name.setPrefSize(320, productDetails[i].getPrefHeight());
            name.setLayoutX(productDetails[i].getPrefWidth() * 0.02);
            name.setLayoutY(productDetails[i].getPrefHeight() / 2 - name.getPrefHeight() / 2);
            Label description = new Label(products.get(i).getProduct().getDescription());
            description.setFont(new Font("Arial", 14));
            description.setTextAlignment(TextAlignment.CENTER);
            description.setPrefSize(400, 40);
            description.setLayoutX(productDetails[i].getPrefWidth() / 2 - description.getPrefWidth() / 2);
            description.setLayoutY(productDetails[i].getPrefHeight() / 2 - description.getPrefHeight() / 2);
            Label price = new Label( products.get(i).getAmount() * products.get(i).getProduct().getPrice() + "");
            price.setTextAlignment(TextAlignment.CENTER);
            price.setPrefSize(120, 40);
            price.setLayoutX(productDetails[i].getPrefWidth() - price.getPrefWidth());
            price.setLayoutY(productDetails[i].getPrefHeight() / 2 - price.getPrefHeight() / 2);

            productDetails[i].getChildren().addAll(name, description, price);
            summary.getChildren().add(productDetails[i]);
        }
        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getAmount() * products.get(i).getProduct().getPrice();
        }
        Label totalLabel = new Label(total + "DKK");
        totalLabel.setFont(new Font("Arial", 14));
        totalLabel.setPrefSize(320, 20);
        totalLabel.setLayoutX(summary.getPrefWidth() - totalLabel.getPrefWidth());
        totalLabel.setLayoutY(summary.getPrefHeight() - totalLabel.getPrefHeight());


        Button payButton = new Button("Pay");
        payButton.setPrefSize(50,20);
        payButton.setLayoutX(totalLabel.getLayoutX());
        payButton.setLayoutY(totalLabel.getLayoutY() + totalLabel.getPrefHeight()- payButton.getPrefHeight());
        payButton.setOnMouseClicked(e->{
            try {
                employeePay();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            root.getChildren().remove(blackoutOverlay);});
        summary.getChildren().addAll(totalLabel, payButton, summaryTitel);






        employeeCheckoutOverlay.getChildren().add(summary);
        root.getChildren().add(employeeCheckoutOverlay);

    }
    public void employeePay() throws InterruptedException {

        Pane blackoutOverlay = new Pane();
        blackoutOverlay.setStyle("-fx-background-color: black");
        blackoutOverlay.setOpacity(0.8);
        blackoutOverlay.setLayoutX(0);
        blackoutOverlay.setLayoutY(0);
        blackoutOverlay.setPrefHeight(env.WINDOW_HEIGHT);
        blackoutOverlay.setPrefWidth(env.WINDOW_WIDTH);
        root.getChildren().add(blackoutOverlay);
        Label paymentStatus = new Label();
        paymentStatus.setPrefSize(300, 150);
        paymentStatus.setTextAlignment(TextAlignment.CENTER);
        paymentStatus.setLayoutY(env.WINDOW_HEIGHT /2 - paymentStatus.getPrefHeight() / 2);
        paymentStatus.setFont(new Font("Arial", 18));
        paymentStatus.setLayoutX(env.WINDOW_WIDTH /2 - paymentStatus.getPrefWidth() / 2);
        root.getChildren().add(paymentStatus);




        PauseTransition paymentDelay = new PauseTransition(Duration.seconds(3));
        paymentDelay.setOnFinished(e -> {
            root.getChildren().removeAll(blackoutOverlay, employeeCheckoutOverlay, paymentStatus);
            basket.getProducts().clear();

        });







        creditInformationInterface creditinfo = new creditInformation();
        double totalprice = 0.0;
        for (int i = 0; i < basket.getProducts().size(); i++) {
            totalprice += basket.getProducts().get(i).getAmount() * basket.getProducts().get(i).getProduct().getPrice();

        }
        if (creditinfo.getFunds() < totalprice) {

            paymentStatus.setStyle("-fx-background-color: red");
            paymentStatus.setText("insufficient credit");
            paymentDelay.play();



        }
        else {
            paymentDelay.play();
            paymentStatus.setStyle("-fx-background-color: green");
            paymentStatus.setText("Payment Successful! \n window will close in 3 seconds");
            paymentStatus.setPrefSize(300, 150);
            paymentStatus.setTextAlignment(TextAlignment.CENTER);
            paymentStatus.setLayoutY(employeeCheckoutOverlay.getPrefHeight() * 0.1);
            paymentStatus.setFont(new Font("Arial", 18));
            paymentStatus.setLayoutX(employeeCheckoutOverlay.getPrefWidth() /2 - paymentStatus.getPrefWidth() / 2);



            creditinfo.subFunds(totalprice);
            if (basket != null && basket.getProducts() != null && basket.getProducts().size() > 0) {
                for (int i = 0; i < products.size(); i++) {
                    for (int j = 0; j < basket.getProducts().get(i).getProduct().getPrice(); j++) {
                        if (basket.getProducts().get(j).getProduct().getId() == products.get(i).getId()) {
                            products.get(i).setQuantity(products.get(i).getQuantity() - 1);

                        }
                    }
                }
            }

        }

    }


}


//