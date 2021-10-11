package com.example.abczone;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MonthsDays extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months_days);

        textView = findViewById(R.id.textView);
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream inputStream = getApplicationContext().getAssets().open("sample.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            ArrayList<Days_Class> months = parseXML(parser);
            String text = "";
            for (Days_Class daysClass : months) {
                text += " Month: " + daysClass.getName() + " has " + daysClass.getCapital() + " days." + "\n\n";
            }
            textView.setText(text);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Days_Class> parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Days_Class> months = null;
        int eventType = parser.getEventType();
        Days_Class month = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name;
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    months = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("month")) {
                        month = new Days_Class();
                        month.id = parser.getAttributeValue(null, "id ");
                    } else if (month != null) {
                        if (name.equals("name")) {
                            month.name = parser.nextText();
                        } else if (name.equals("capital")) {
                            month.capital = parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("month") && month != null) {
                        months.add(month);
                    }
            }
            eventType = parser.next();
        }
        return months;
    }

}