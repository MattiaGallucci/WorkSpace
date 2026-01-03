import React from 'react';
import { Code, ShieldCheck, Brain } from 'lucide-react';

const AboutSection: React.FC = () => {
  return (
    <section id="about" className="py-20 bg-white dark:bg-gray-900">
      <div className="container mx-auto px-4">
        <div className="flex flex-col md:flex-row gap-12 items-center">
          <div className="md:w-1/2">
            <div className="rounded-lg overflow-hidden shadow-lg transform transition-transform hover:scale-105">
              <img 
                src="/images/coding.jpg" 
                alt="Coding" 
                className="w-full h-auto object-cover" 
              />
            </div>
          </div>
          
          <div className="md:w-1/2">
            <h2 className="text-3xl font-bold mb-6 text-gray-800 dark:text-white">
              <span className="text-teal-600 dark:text-teal-400">✨</span> Chi sono
            </h2>
            
            <div className="space-y-4 text-gray-700 dark:text-gray-300">
              <p className="leading-relaxed">
                Ciao! Mi chiamo <span className="font-semibold text-teal-600 dark:text-teal-400">Mattia Gallucci</span>, sono uno studente al terzo anno del corso di laurea triennale in Informatica presso l'Università degli Studi di Salerno.
              </p>
              
              <p className="leading-relaxed">
                Fin dai primi esami ho sviluppato una forte passione per tutto ciò che riguarda la sicurezza informatica, l'ingegneria del software e l'intelligenza artificiale. Questi tre mondi, così diversi eppure interconnessi, mi affascinano per le loro sfide e per l'impatto che possono avere nella vita reale.
              </p>
              
              <p className="leading-relaxed">
                Credo che l'informatica sia una forma di potere creativo, e sono determinato a crescere, imparare e dare il mio contributo nel settore.
              </p>
            </div>
            
            <div className="mt-8 grid grid-cols-1 sm:grid-cols-3 gap-4">
              <div className="p-4 bg-gray-50 dark:bg-gray-800 rounded-lg transition-transform hover:scale-105">
                <ShieldCheck className="h-8 w-8 text-teal-600 dark:text-teal-400 mb-2" />
                <h3 className="font-medium text-gray-800 dark:text-white">Sicurezza Informatica</h3>
              </div>
              
              <div className="p-4 bg-gray-50 dark:bg-gray-800 rounded-lg transition-transform hover:scale-105">
                <Code className="h-8 w-8 text-teal-600 dark:text-teal-400 mb-2" />
                <h3 className="font-medium text-gray-800 dark:text-white">Ingegneria del Software</h3>
              </div>
              
              <div className="p-4 bg-gray-50 dark:bg-gray-800 rounded-lg transition-transform hover:scale-105">
                <Brain className="h-8 w-8 text-teal-600 dark:text-teal-400 mb-2" />
                <h3 className="font-medium text-gray-800 dark:text-white">Intelligenza Artificiale</h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AboutSection;