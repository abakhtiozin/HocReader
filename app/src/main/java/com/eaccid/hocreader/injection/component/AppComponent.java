package com.eaccid.hocreader.injection.component;

import android.content.Context;
import com.eaccid.hocreader.data.remote.libtranslator.lingualeo_impl.dictionary.LingualeoDictionaryRx;
import com.eaccid.hocreader.injection.ApplicationContext;
import com.eaccid.hocreader.injection.module.AppModule;
import com.eaccid.hocreader.injection.module.DatabaseModule;
import com.eaccid.hocreader.injection.module.DataProviderModule;
import com.eaccid.hocreader.presentation.main.MainPresenter;
import com.eaccid.hocreader.presentation.main.ins.directories.DirectoriesPreferences;
import com.eaccid.hocreader.presentation.main.ins.directories.DirectoryChooser;
import com.eaccid.hocreader.provider.NetworkAvailablenessImpl;
import com.eaccid.hocreader.presentation.memorizing.cardremember.CardWordPresenter;
import com.eaccid.hocreader.presentation.book.BookPresenter;
import com.eaccid.hocreader.provider.semantic.ImageViewLoader;
import com.eaccid.hocreader.presentation.memorizing.MemorizingPresenter;
import com.eaccid.hocreader.presentation.memorizing.SchedulingMemorizingAlarmManager;
import com.eaccid.hocreader.provider.db.words.BookOnReadProvider;
import com.eaccid.hocreader.provider.db.words.WordCursorProvider;
import com.eaccid.hocreader.provider.translator.LingualeoServiceCookiesImpl;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DatabaseModule.class})
@Singleton
public interface AppComponent {

    WordListComponent plusWordListComponent(DataProviderModule dataProviderModule);

    @ApplicationContext
    Context context();

    void inject(LingualeoServiceCookiesImpl leoCookies);

    void inject(LingualeoDictionaryRx dictionaryRx);

    void inject(ImageViewLoader imageViewManager);

    void inject(MainPresenter mainPresenter);

    void inject(MemorizingPresenter memorizingPresenter);

    void inject(SchedulingMemorizingAlarmManager schedulingMemorizingAlarmManager);

    void inject(WordCursorProvider wordCursorProvider);

    void inject(CardWordPresenter cardWordPresenter);

    void inject(BookOnReadProvider bookOnReadProvider);

    void inject(BookPresenter bookPresenter);

    void inject(NetworkAvailablenessImpl networkAvailableness);

    void inject(DirectoriesPreferences customDirectories);

    void inject(DirectoryChooser directoryChooser);

}
