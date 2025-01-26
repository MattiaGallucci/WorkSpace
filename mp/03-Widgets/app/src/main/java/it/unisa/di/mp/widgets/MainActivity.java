package it.unisa.di.mp.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
    private GridView gridView;
    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DEBUG","onCreate()");
        setContentView(R.layout.main_layout);

        /*
         * Codice per il video
         */
        vv = (VideoView) findViewById(R.id.videoView1);

        vv.setVideoURI(Uri.parse("android.resource://it.unisa.di.mp.widgets/raw/muppet"));

        MediaController mc = new MediaController(this);
        vv.setMediaController(mc);

        /*
         * Codice per AutoCompleteTextView (serve la lista delle nazioni - vedi res/strings.xml)
         */

        final String[] lista_nazioni = getResources().getStringArray(R.array.nazioni);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, lista_nazioni);
        textView.setAdapter(adapter);

        /*
         * Codice per il gridView
         */
        gridView = (GridView)findViewById(R.id.gridView1);

        gridView.setAdapter(new ImageAdapter(this, imagesIds));

    }

    public class ImageAdapter extends BaseAdapter {
        private static final int pad = 8;
        private static final int imageWidth = 100;
        private static final int imageHeight = 100;
        private Context context;
        private List<Integer> imgIds;

        public ImageAdapter(Context c, List<Integer> ids) {
            context = c;
            imgIds = ids;
        }

        @Override
        public int getCount() {
            return imgIds.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        // Serve se vogliamo usare OnItemClickListener.onItemClick()
        @Override
        public long getItemId(int position) {
            return imgIds.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = (ImageView) convertView;

            if (imageView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(imageWidth, imageHeight));
                imageView.setPadding(pad, pad, pad, pad);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }

            imageView.setImageResource(imgIds.get(position));
            return imageView;
        }
    }


    /*
     * Array per le immagini del GridView
     */
    private ArrayList<Integer> imagesIds = new ArrayList<Integer>(
            Arrays.asList(R.drawable.img01,
                    R.drawable.img02,
                    R.drawable.img03,
                    R.drawable.img04,
                    R.drawable.img05,
                    R.drawable.img06,
                    R.drawable.img07,
                    R.drawable.img08,
                    R.drawable.img09,
                    R.drawable.img10,
                    R.drawable.img11,
                    R.drawable.img12,
                    R.drawable.img13,
                    R.drawable.img14,
                    R.drawable.img15,
                    R.drawable.img16,
                    R.drawable.img17,
                    R.drawable.img18,
                    R.drawable.img19,
                    R.drawable.img20,
                    R.drawable.img21,
                    R.drawable.img22,
                    R.drawable.img23,
                    R.drawable.img24,
                    R.drawable.img25
            ));

}