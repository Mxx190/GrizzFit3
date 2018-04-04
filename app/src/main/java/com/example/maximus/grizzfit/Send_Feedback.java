package com.example.maximus.grizzfit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Send_Feedback extends Fragment {

    View currentView;

    private EditText to;
    private EditText subject;
    private EditText message;
    private Button sendEmail;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View currentView = inflater.inflate(R.layout.fragment_send__feedback, container, false);


        to = (EditText) currentView.findViewById(R.id.emailIDEditTxt);

        subject = (EditText) currentView.findViewById(R.id.subjectEditTxt);

        message = (EditText) currentView.findViewById(R.id.messageEditTxt);

        sendEmail = (Button) currentView.findViewById(R.id.sendEmailBtn);

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String toS = to.getText().toString();

                System.out.println(toS);

                String subS = subject.getText().toString();

                String mesS = message.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { toS});
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                email.putExtra(Intent.EXTRA_TEXT, mesS);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose app to send mail"));

            }
        });

        return currentView;
    }

}
