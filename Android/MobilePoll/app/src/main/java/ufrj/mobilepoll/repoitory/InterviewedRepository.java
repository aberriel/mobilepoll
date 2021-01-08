package ufrj.mobilepoll.repoitory;

import android.content.Context;

import ufrj.mobilepoll.database.helper.InterviewedDbHelper;
import ufrj.mobilepoll.database.helper.PersonDbHelper;
import ufrj.mobilepoll.model.Interviewed;

/**
 * Repositório de dados para entrevistados
 * Created by alira on 14/10/15.
 */
public class InterviewedRepository
{
    PersonDbHelper personHelper;
    InterviewedDbHelper interviewedHelper;

    public InterviewedRepository(Context context)
    {
        personHelper = new PersonDbHelper(context);
        interviewedHelper = new InterviewedDbHelper(context);
    }
}