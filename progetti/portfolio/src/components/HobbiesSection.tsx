import React from 'react';
import { Gamepad2, Dumbbell } from 'lucide-react';

const HobbiesSection: React.FC = () => {
  return (
    <section id="hobbies" className="py-20 bg-white dark:bg-gray-900">
      <div className="container mx-auto px-4">
        <h2 className="text-3xl font-bold mb-2 text-center text-gray-800 dark:text-white">
          <span className="text-teal-600 dark:text-teal-400">🎮</span> Passioni e Hobby
        </h2>
        <p className="text-center text-gray-600 dark:text-gray-400 mb-12 max-w-2xl mx-auto">
          Quando non sono impegnato con il codice o lo studio, mi piace dedicare il mio tempo ad attività che mi permettono di ricaricare le energie e stimolare la mente.
        </p>
        
        <div className="grid grid-cols-1 md:grid-cols-2 gap-12">
          {/* Gaming Hobby */}
          <div className="bg-gray-50 dark:bg-gray-800 rounded-lg overflow-hidden shadow-md transition-transform hover:scale-105">
            <div className="h-64 overflow-hidden">
              <img 
                src="/images/videogiochi.jpg" 
                alt="Gaming Setup" 
                className="w-full h-full object-cover transition-transform hover:scale-110"
              />
            </div>
            <div className="p-6">
              <div className="flex items-center mb-4">
                <Gamepad2 className="h-6 w-6 text-teal-600 dark:text-teal-400 mr-2" />
                <h3 className="text-xl font-bold text-gray-800 dark:text-white">Videogiochi</h3>
              </div>
              <p className="text-gray-600 dark:text-gray-300">
                Mi affascinano i titoli che uniscono storytelling, strategia e design: un mix che, a mio parere, ha molto in comune con la programmazione. I videogiochi sono per me una forma d'arte e una palestra per la mente, dove posso esplorare mondi virtuali e risolvere problemi complessi.
              </p>
              <div className="mt-4 flex flex-wrap gap-2">
                <span className="text-xs bg-gray-100 dark:bg-gray-700 text-gray-600 dark:text-gray-300 px-2 py-1 rounded">
                  Storytelling
                </span>
                <span className="text-xs bg-gray-100 dark:bg-gray-700 text-gray-600 dark:text-gray-300 px-2 py-1 rounded">
                  Strategia
                </span>
                <span className="text-xs bg-gray-100 dark:bg-gray-700 text-gray-600 dark:text-gray-300 px-2 py-1 rounded">
                  Problem Solving
                </span>
              </div>
            </div>
          </div>
          
          {/* Gym Hobby */}
          <div className="bg-gray-50 dark:bg-gray-800 rounded-lg overflow-hidden shadow-md transition-transform hover:scale-105">
            <div className="h-64 overflow-hidden">
              <img 
                src="/images/palestra.jpg" 
                alt="Fitness Gym" 
                className="w-full h-full object-cover transition-transform hover:scale-110"
              />
            </div>
            <div className="p-6">
              <div className="flex items-center mb-4">
                <Dumbbell className="h-6 w-6 text-teal-600 dark:text-teal-400 mr-2" />
                <h3 className="text-xl font-bold text-gray-800 dark:text-white">Palestra</h3>
              </div>
              <p className="text-gray-600 dark:text-gray-300">
                La palestra è il mio modo per ritrovare energia e concentrazione. L'attività fisica è un complemento perfetto alla vita digitale: mi aiuta a mantenere un equilibrio tra mente e corpo, a scaricare lo stress e a migliorare la mia disciplina quotidiana.
              </p>
              <div className="mt-4 flex flex-wrap gap-2">
                <span className="text-xs bg-gray-100 dark:bg-gray-700 text-gray-600 dark:text-gray-300 px-2 py-1 rounded">
                  Fitness
                </span>
                <span className="text-xs bg-gray-100 dark:bg-gray-700 text-gray-600 dark:text-gray-300 px-2 py-1 rounded">
                  Disciplina
                </span>
                <span className="text-xs bg-gray-100 dark:bg-gray-700 text-gray-600 dark:text-gray-300 px-2 py-1 rounded">
                  Equilibrio
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default HobbiesSection;