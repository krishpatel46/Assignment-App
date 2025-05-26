package com.example.assignmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {

    LinearLayout creditScoreMetric, lifetimeCBMetric, bankBalanceMetric;
    LinearLayout cashbackBalance, coinsInfo, referAndEarn;

    TextView profileName, profileCreationDate;

    ImageButton appBarBackbtn, credGarageBtn;
    MaterialButton profileEditBtn, appBarSupportBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //-- 1. set user profile info
        String username = "Andaz Kumar";
        String memberCreationDate = "member since Dec, 2020";

        profileName = findViewById(R.id.profileName);
        profileCreationDate = findViewById(R.id.profileCreationDate);

        profileName.setText(username);
        profileCreationDate.setText(memberCreationDate);

        //-- 2. set credit score, lifetime cashback amount, and bank balance amount
        creditScoreMetric = findViewById(R.id.creditScoreMetric);
        lifetimeCBMetric = findViewById(R.id.lifetimeCBMetric);
        bankBalanceMetric = findViewById(R.id.bankBalanceMetric);

        setFinancialMetrics(creditScoreMetric, R.drawable.ic_credit_dial, "credit score",
                "757","REFRESH AVAILABLE");
        setFinancialMetrics(lifetimeCBMetric, R.drawable.ic_rupee, "lifetime cashback",
                "₹3",null);
        setFinancialMetrics(bankBalanceMetric, R.drawable.ic_upi, "bank balance",
                "check",null);

        //-- 3. set cashback balance, coins, and 'win upto' ad
        cashbackBalance = findViewById(R.id.cashbackBalance);
        coinsInfo = findViewById(R.id.coinsInfo);
        referAndEarn = findViewById(R.id.referAndEarn);

        setRewardMetrics(cashbackBalance, "cashback balance", "₹0");
        setRewardMetrics(coinsInfo, "coins", "26,46,583");
        setRewardMetrics(referAndEarn, "win upto Rs 1000", "refer and earn");

        //-- 4. set button click listeners
        appBarBackbtn = findViewById(R.id.appBar_backBtn);
        appBarBackbtn.setOnClickListener(view -> {
            Toast.makeText(this, "Go back to home screen", Toast.LENGTH_SHORT).show();
        });

        credGarageBtn = findViewById(R.id.credGarageBtn);
        credGarageBtn.setOnClickListener(view -> {
            Toast.makeText(this, "Explore CRED garage", Toast.LENGTH_SHORT).show();
        });

        profileEditBtn = findViewById(R.id.profileEditBtn);
        profileEditBtn.setOnClickListener(view -> {
            Toast.makeText(this, "Edit your profile info", Toast.LENGTH_SHORT).show();
        });

        appBarSupportBtn = findViewById(R.id.appBar_supportBtn);
        appBarSupportBtn.setOnClickListener(view -> {
            Toast.makeText(this, "We are here to support", Toast.LENGTH_SHORT).show();
        });

        //-- similarly, other buttons can be set
    }

    public void setFinancialMetrics(LinearLayout container, int iconResId, String metricTitle,
                                    String metricValue, String msgChipInfo) {

        ImageView icon = container.findViewById(R.id.metricImg);
        TextView title = container.findViewById(R.id.metricTitle);
        TextView value = container.findViewById(R.id.metricValue);
        TextView msgChip = container.findViewById(R.id.creditRefreshMsgChip);

        icon.setImageResource(iconResId);
        title.setText(metricTitle);
        value.setText(metricValue);

        if (msgChipInfo == null || msgChipInfo.trim().isEmpty())
            msgChip.setVisibility(View.GONE);
        else {
            msgChip.setVisibility(View.VISIBLE);
            msgChip.setText(msgChipInfo);
        }
    }

    public void setRewardMetrics(LinearLayout container, String rewardTitle, String rewardValue) {
        TextView title = container.findViewById(R.id.rewardTitle);
        TextView value = container.findViewById(R.id.rewardValue);

        title.setText(rewardTitle);
        value.setText(rewardValue);
    }
}