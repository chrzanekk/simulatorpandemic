CREATE TABLE if not exists simulation
(
    id serial primary key,
    simulation_name varchar(50),
    population_size integer,
    initial_no_of_infected_ppl integer,
    infection_rade float,
    mortality_rate float,
    infected_to_cure_duration integer,
    infected_to_death_duration integer,
    days_of_simulation integer
);

CREATE TABLE if not exists simulated_population
(
    id serial primary key,
    simulation_id integer,
    no_of_infected_ppl integer,
    no_of_healthy_susceptible_for_infection integer,
    no_of_deaths integer,
    no_of_cured_and_immune integer
);