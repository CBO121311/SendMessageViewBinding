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
 * Créitos: daniel-stoneuk por la librería de GitHub
 * @author Alejandro López
 * @version 1.0
 */
public class AboutActivity extends MaterialAboutActivity {
    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {

        MaterialAboutCard.Builder authorCard = new MaterialAboutCard.Builder();
        authorCard.title(R.string.about_autor);
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.about_alejandro_l_pez)
                .subText(R.string.about_alumno_2_dam)
                .icon(R.drawable.ic_action_person)
                .build());
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.abut_bifurcar_en_github)
                .icon(R.drawable.ic_action_share)
                .setOnClickAction(() -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_url_repos_GitHub)));
                    startActivity(intent);
                })
                .build());
        authorCard.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.about_mi_linkedin)
                .icon(R.drawable.ic_action_linkedin)
                .setOnClickAction(() -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_url_linkedin)));
                    startActivity(intent);
                })
                .build());

        MaterialAboutCard.Builder cardBuilder = new MaterialAboutCard.Builder();
        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.about_version)
                .subText(R.string.about_num_version)
                .icon(R.drawable.ic_action_info)
                .build());

        return new MaterialAboutList.Builder()
                .addCard(authorCard.build())
                .addCard(cardBuilder.build())
                .build();
    }


    /***
     * Método sobreescrito que muestra el título de la actividad
     * @return devuelve la cadena "Acerca de"
     */
    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mal_title_about);
    }
}


