CREATE TABLE if not exists simulation
(
    id                         serial primary key,
    simulation_name            varchar(50),
    population_size            integer,
    initial_no_of_infected_ppl integer,
    infection_rade             float,
    mortality_rate             float,
    infected_to_cure_duration  integer,
    infected_to_death_duration integer,
    days_of_simulation         integer
);

CREATE TABLE if not exists simulated_population
(
    id                                      serial primary key,
    simulation_id                           integer,
    no_of_infected_ppl                      integer,
    no_of_healthy_susceptible_for_infection integer,
    no_of_deaths                            integer,
    no_of_cured_and_immune                  integer
);

INSERT INTO simulation (simulation_name, population_size, initial_no_of_infected_ppl, infection_rade, mortality_rate,
                        infected_to_cure_duration, infected_to_death_duration, days_of_simulation)
VALUES ('simulation1', 10000, 4, 1.4, 0.9, 7, 14, 30),
       ('simulation2', 50000, 6, 1.2, 1.1, 9, 21, 60),
       ('simulation3', 100000, 8, 1.0, 1.3, 7, 15, 90);

INSERT INTO simulated_population (simulation_id, no_of_infected_ppl, no_of_healthy_susceptible_for_infection,
                                  no_of_deaths, no_of_cured_and_immune)
VALUES ((SELECT simulation.id FROM simulation WHERE simulation_name = 'simulation1'), 666, 30, 15, 222),
       ((SELECT simulation.id FROM simulation WHERE simulation_name = 'simulation2'), 25000, 100, 30, 4444),
       ((SELECT simulation.id FROM simulation WHERE simulation_name = 'simulation3'), 65000, 600, 45, 6666)