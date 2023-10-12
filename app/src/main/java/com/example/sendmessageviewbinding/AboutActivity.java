package com.example.sendmessageviewbinding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

/***
 * Clase que muestra la información acerca de la aplicación y su autor.
 *
 * @author Alejandro López
 * @version 1.0
 */
public class AboutActivity extends MaterialAboutActivity {
    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {

        MaterialAboutCard.Builder authorCard = new MaterialAboutCard.Builder();
        authorCard.title("Autor");
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Alejandro López")
                .subText("Alumno 2ºDAM")
                .icon(R.drawable.ic_action_person)
                .build());
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Fork on GitHUB")
                .icon(R.drawable.ic_action_share)
                .setOnClickAction(() -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/CBO121311/SendMessageViewBinding"));
                    startActivity(intent);
                })
                .build());
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text("Mi LinkedIn")
                .icon(R.drawable.ic_action_linkedin)
                .setOnClickAction(() -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/alecbo/"));
                    startActivity(intent);
                })
                .build());


        MaterialAboutCard.Builder cardBuilder = new MaterialAboutCard.Builder();
        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("Version")
                .subText("1.0.0")
                .icon(R.drawable.ic_action_info)
                .build());

        return new MaterialAboutList.Builder()
                .addCard(authorCard.build())
                .addCard(cardBuilder.build())
                .build();
    }


    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mal_title_about);
    }
}


