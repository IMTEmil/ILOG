package fr.imtld.ilog;

public class RendezVous {
        protected int n;
        protected int i;

        RendezVous(int n)
        {
                this.n = n;
        }

        void jeSuisLa()
        {
                i++;
                synchronized(this)
                {
                        try {
                                if (i != n) wait();
                        } catch (InterruptedException e) {
                                notify();
                        }
                }
        }

}
